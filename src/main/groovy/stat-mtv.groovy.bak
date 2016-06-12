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

	def yestoday = day - 1
	def today = day
	println 'from ' + yestoday + ' to ' + today

	ss << wrapTd(yestoday.format('MM-dd'))

	// 扫描次数
	def scan = db.rows('''
		select openid from ih_mtv_show_scan_log where type = ? and dd >= ? and dd < ?
	'''
	, ['scan', yestoday, today])
	println 'scan number ' + scan.size()
	ss << wrapTd('' + scan.size())

	// 扫描用户数
	def scanUser = db.rows('''
		select distinct openid from ih_mtv_show_scan_log where type = ? and dd >= ? and dd < ?
	'''
	, ['scan', yestoday, today])
	println 'scanUser number ' + scanUser.size()
	ss << wrapTd('' + scanUser.size())

	// 通过扫描新增用户数
	def focusUserByScan = db.rows('''
		SELECT openid from ih_mtv_show_scan_log where type = ? and is_new = ? and dd >= ? and dd < ?
	'''
	, ['scan', 1, yestoday, today])
	println 'focusUserByScan number ' + focusUserByScan.size()
	ss << wrapTd('' + focusUserByScan.size())

	// 生成图片数量
	def picNum = db.rows('''
		select openid from ih_mtv_show_scan_log where type = ? and dd >= ? and dd < ?
	'''
	, ['upload-pic', yestoday, today])
	println 'picNum number ' + picNum.size()
	ss << wrapTd('' + picNum.size())

	// 访问页面次数
	def visitPage = db.rows('''
		select openid from ih_mtv_show_scan_log where type = ? and dd >= ? and dd < ?
	'''
	, ['visit-make-page', yestoday, today])
	println 'visitPage number ' + visitPage.size()
	ss << wrapTd('' + visitPage.size())

	// 访问页面用户数
	def visitUser = db.rows('''
		select distinct openid from ih_mtv_show_scan_log where type = ? and dd >= ? and dd < ?
	'''
	, ['visit-make-page', yestoday, today])
	println 'visitUser number ' + visitUser.size()
	ss << wrapTd('' + visitUser.size())

	// 次日留存用户数
	def focusUserNextdayAct = db.rows('''
		select distinct a.openid from ih_mtv_show_scan_log a  INNER JOIN 
		ih_mtv_show_scan_log b on a.openid = b.openid where b.dd >= ? and b.dd < ?
		and  a.type='scan' and a.is_new = 1 and a.dd >= ? and a.dd < ?

	'''
	, [yestoday, today, yestoday - 1, yestoday])
	println 'focusUserNextdayAct number ' + focusUserNextdayAct.size()
	ss << wrapTd('' + focusUserNextdayAct.size())

	// 留存用户访问次数
	def focusUserVisit = db.rows('''
		select a.openid from ih_mtv_show_scan_log a  left JOIN 
		ih_mtv_show_scan_log b on a.openid = b.openid where b.dd >= ? and b.dd < ?
		and  a.type='scan' and a.is_new = 1 and a.dd >= ? and a.dd < ?
	'''
	, [yestoday, today, yestoday - 1, yestoday])
	println 'focusUserVisit number ' + focusUserVisit.size()
	ss << wrapTd('' + focusUserVisit.size())

	ss.toString()
}

def day = new Date() + 1
day.hours = 0
day.minutes = 0
day.seconds = 0


StringBuilder sb = new StringBuilder()
sb << """
<!doctype html>
<html>
	<head>
		<title> MTV各项数据统计 </title>
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
		<td>扫描次数</td>
		<td>扫描用户数 </td>
		<td>通过扫描新增用户 </td>
		<td>生成图片数量 </td>
		<td>访问页面次数(pv)</td>
		<td>访问页面用户数(uv)</td>
		<td>次日留存用户数</td>
		<td>次日留存用户访问页面次数 </td>
	</tr>
	"""

for(one in 0..3){
	sb << '<tr>'
	sb << getOneDayStat(day - one)
	sb << '</tr>'
}

sb << '</table></body></html>'

new File('stat-mtv.html').text = sb.toString()

db.close()

