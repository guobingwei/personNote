import groovy.sql.*


String conf1 = '''
com.mysql.jdbc.Driver
jdbc:mysql://start.innohub.io:3306/innohub?useUnicode=true&characterEncoding=UTF-8
innohub
Innohub2015
'''

def getDb = {str ->
    def p = [:]

    def ll = str.readLines().collect{it.trim()}.grep{it}
    p.url = ll[1]
    p.u = ll[2]
    p.p = ll[3]
    p.driver = ll[0]

    if(p.p == '"'){
        p.p = ''
    }

    Sql.newInstance(p.url, p.u, p.p, p.driver)
}

def db = getDb(conf1)

def beginDay = new Date() - 10
beginDay.hours = 0
beginDay.minutes = 0
beginDay.seconds = 0

String beginDayStr = beginDay.format('yyyy-MM-dd')

def rowCard = db.rows('''
	select count(id) as num, DATE_FORMAT(dd,'%m-%d') as dd from ih_wx_card group by DATE_FORMAT(dd,'%m-%d') order by DATE_FORMAT(dd,'%m-%d') desc limit 10;
'''
)
def rowCardFill = db.rows('''
	select count(id) as num, DATE_FORMAT(dd,'%m-%d') as dd  from ih_wx_card where name is not null group by DATE_FORMAT(dd,'%m-%d') order by DATE_FORMAT(dd,'%m-%d') desc limit 10;
'''
)

def rowExchange = db.rows('''
	select count(id) as num, DATE_FORMAT(dd,'%m-%d') as dd  from ih_wx_card_tpl_send_log group by DATE_FORMAT(dd,'%m-%d') order by DATE_FORMAT(dd,'%m-%d') desc limit 10;
'''
)

def rowScanButNotFill = db.rows("""
	select count(d.scan_id) as num, d.dd from 
	(select scan_id, DATE_FORMAT(dd,'%m-%d') as dd from 
	(select a.dd, b.id as scan_id from (select openid, dd from ih_wx_card where name is null and dd >= ?) a left join ih_wx_card_scan_log b 
		on a.openid = b.from_openid) c where c.scan_id is not null) d group by d.dd order by d.dd desc
"""
, [beginDayStr])

db.close()


StringBuilder sb = new StringBuilder()
sb << """
<!doctype html>
<html>
	<head>
		<title> 统计 </title>
		<style>
		table td {
			border: 1px solid #ccc;
		}
		</style>
	</head>

	<body>
	<table>
	<tr>
		<td>日期</td>
		<td>新增用户</td>
		<td>成名片生成用户</td>
		<td>交换名片成功次数</td>
		<td>单边交换次数</td>
	</tr>
	"""

for(one in rowCard){
	def xx = rowCardFill.find{it.dd == one.dd}
	if(xx)
		one.numFill = xx.num
	else
		one.numFill = -1

	xx = rowExchange.find{it.dd == one.dd}
	if(xx)
		one.numExchange = xx.num
	else
		one.numExchange = -1

	xx = rowScanButNotFill.find{it.dd == one.dd}
	if(xx)
		one.numExchangeOneSide = xx.num
	else
		one.numExchangeOneSide = -1
	
	sb << """
	<tr>
		<td>${one.dd}</td>
		<td>${one.num}</td>
		<td>${one.numFill}</td>
		<td>${one.numExchange}</td>
		<td>${one.numExchangeOneSide}</td>
	</tr>
	"""
}

sb << '</table></body></html>'

new File('stat-card.html').text = sb.toString()