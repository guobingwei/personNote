import org.paic.d.D

// score
def updateScore = {
	def d = D.gen()

	def needAddList = d.query("""
			SELECT * from (SELECT openid from ih_wx_user WHERE from_unixtime(add_time/1000,'%Y-%m-%d %H:%M') >='2015-12-07 16:33'  )a
	INNER JOIN 
	(SELECT * from ih_wx_card_scan_log WHERE dd>='2015-12-07 16:34' and dd < '2015-12-08 10:39' )b
	on a.openid = b.from_openid
	""")

	for(one in needAddList[1..-1]) {
		Map temp = [:]
		temp.openid = one.toOpenid
		temp.fromOpenid = one.fromOpenid
		temp.type = 'bring_new_when_scan'
		temp.amount = 50
		temp.dayLabel = '2015-12-07'
		temp.dd = one.dd
		d.add(temp, 'ih_comm_score')
	}
}

// stat
def updateScoreStat = {
	def d = D.gen()
	def needAddStatList = d.query("""
		SELECT count(*) as num,  to_openid from  (
	SELECT * from (SELECT openid from ih_wx_user WHERE from_unixtime(add_time/1000,'%Y-%m-%d %H:%M') >='2015-12-07 16:33'  )a
	INNER JOIN 
	(SELECT * from ih_wx_card_scan_log WHERE dd>='2015-12-07 16:34' and dd < '2015-12-08 10:39' )b
	on a.openid = b.from_openid)  c GROUP BY to_openid
	""")

	for(one in needAddStatList[1..-1]) {
		d.exe("update ih_comm_score_stat set amount = amount + ${one.num} * 50, update_time = ? WHERE openid = ? and week_label = '2015-12-07'", [System.currentTimeMillis(), one.toOpenid])
		println 'done update stat ' + one.toOpenid
	}
}

// 更新EveryDay
def updateScoreEveryDay = {
	def d = D.gen()
	def needAddEveryDayList = d.query("""
			SELECT count(*) as num,  to_openid from  (
			SELECT * from (SELECT openid from ih_wx_user WHERE from_unixtime(add_time/1000,'%Y-%m-%d %H:%M') >='2015-12-07 16:33'  )a
			INNER JOIN 
			(SELECT * from ih_wx_card_scan_log WHERE dd>='2015-12-07 16:34' and dd < '2015-12-08 10:39' )b
			on a.openid = b.from_openid)  c GROUP BY to_openid
	""")

	for(one in needAddEveryDayList[1..-1]) {
		d.exe("update ih_comm_score_stat_everyday set amount = amount + ${one.num} * 50, update_time = ? WHERE openid = ? and day_label = '2015-12-07'", [System.currentTimeMillis(), one.toOpenid])
		println 'done update stat ' + one.toOpenid
	}
}

updateScore()
updateScoreStat()
updateScoreEveryDay()