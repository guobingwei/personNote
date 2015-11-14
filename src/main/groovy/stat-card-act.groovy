import groovy.sql.*

// 一天的留存用户统计
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

def getOneDayStat = {Date day ->
	def yestoday = day - 1
	def yestodayBefore = yestoday - 1
	def today = day
	println 'from ' + yestoday + ' to ' + today

	def cards = db.rows('''
		select openid from ih_wx_card where dd >= ? and dd < ? 
	'''
	, [yestodayBefore.format('yyyy-MM-dd'), yestoday.format('yyyy-MM-dd')])

	println 'cards number ' + cards.size()

	def incUserList = db.rows('''
		select openid from ih_wx_user where add_time >= ? and add_time < ? 
	'''
	, [yestodayBefore.time, yestoday.time])
	println 'increased user number ' + incUserList.size()

	def cardsOpenidList = cards.collect{it.openid}
	def userFillList = incUserList.grep{it.openid in cardsOpenidList}
	println 'increased user because card number ' + userFillList.size()

	def scanList = db.rows('select * from ih_wx_card_scan_log where dd >= ? and dd < ?', [yestoday.format('yyyy-MM-dd'), today.format('yyyy-MM-dd')])
	def visitList = db.rows('select * from ih_wx_card_visit_stat_log where dd >= ? and dd < ?', [yestoday.format('yyyy-MM-dd'), today.format('yyyy-MM-dd')])

	def visitOpenidList = visitList.collect{it.openid}
	def scanFromOpenidList = scanList.collect{it.from_openid}
	def scanToOpenidList = scanList.collect{it.to_openid}

	for(one in userFillList){
		String openid = one.openid
		if(openid in scanFromOpenidList)
			one.scanFrom = true
		else
			one.scanFrom = false

		if(openid in scanToOpenidList)
			one.scanTo = true
		else
			one.scanTo = false

		if(openid in visitOpenidList)
			one.openSelf = true
		else
			one.openSelf = false

		println one.openid.padRight(50, ' ') + (one.scanFrom ? '1' : '0') + '  ' + (one.scanTo ? '1' : '0') + '  ' + (one.openSelf ? '1' : '0')
	}

	println userFillList.size()
	println userFillList.count{it.scanFrom || it.scanTo || it.openSelf}
}

	def day = new Date() 
day.hours = 0
day.minutes = 0
day.seconds = 0

getOneDayStat(day)

db.close()

