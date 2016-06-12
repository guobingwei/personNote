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

def wrapTd = {String c ->
	'<td>' + c + '</td>'
}

def getOneDayStat = {Date day ->
	StringBuilder ss = new StringBuilder()

	def yestoday = day
	def today = yestoday + 1
	println 'from ' + yestoday + ' to ' + today

	ss << wrapTd(yestoday.format('MM-dd'))

	def cards = db.rows('''
		select openid from ih_wx_card where dd >= ? and dd < ? 
	'''
	, [yestoday.format('yyyy-MM-dd'), today.format('yyyy-MM-dd')])

	println 'cards number ' + cards.size()

	def incUserList = db.rows('''
		select openid from ih_wx_user where add_time >= ? and add_time < ? 
	'''
	, [yestoday.time, today.time])
	println 'increased user number ' + incUserList.size()
	ss << wrapTd('' + incUserList.size())

	def cardsOpenidList = cards.collect{it.openid}
	int inCardIncNum = incUserList.count{it.openid in cardsOpenidList}

	ss << wrapTd('' + inCardIncNum)

	ss.toString()
}

def day = new Date() 
day.hours = 0
day.minutes = 0
day.seconds = 0


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
		<td>通过卡片的新增用户</td>
	</tr>
	"""

for(one in 1..7){
	sb << '<tr>'
	sb << getOneDayStat(day - one)
	sb << '</tr>'
}

sb << '</table></body></html>'

new File('stat-card-inc.html').text = sb.toString()

db.close()

