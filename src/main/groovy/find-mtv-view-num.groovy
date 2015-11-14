import groovy.sql.*
import com.alibaba.fastjson.JSON


boolean isParseSql = false
if(args.size())
	isParseSql = true

// TODO
int prdSeq = 1

if(isParseSql){
	String conf1 = '''
	com.mysql.jdbc.Driver
	jdbc:mysql://192.168.100.4:3306/innohub?useUnicode=true&characterEncoding=UTF-8
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

	def ll1 = JSON.parse(new File('openids-prd1.txt').text)
	def ll2 = JSON.parse(new File('openids-prd2.txt').text)
	def ll3 = JSON.parse(new File('openids-prd3.txt').text)

	List ll = []
	for(oneList in [ll1, ll2, ll3]){
		for(one in oneList){
			if(!ll[one.dat])
				ll[one.dat] = []

			ll[one.dat].addAll(one.openids)
		}
	}

	ll.each{
		List openids = it.openids
		openids.unique()

		String clause = openids.collect{i -> 
			"'" + i + "'"
		}.join(',')

		String sql = "select type, count(id) as num from ih_mtv_show_scan_log where openid in (${clause}) and dd >= ? and dd < ? group by type"

		String fmt = 'yyyy-MM-dd'
		Date datNext = Date.parse(fmt, it.dat) + 1
		String datNextDay = datNext.format(fmt)
		def rows = db.rows(sql, [it.dat, datNextDay])
		println it.dat + ' - ' + openids.size() + ' - ' + rows
	}

	db.close()
}else{
	def ll = new File('/home/innohub/logs').listFiles().grep{it.name ==~ /^innohub.+log$/}.collect{
		String dat = it.name.split(/\./)[1]
		List openids  = it.readLines().grep{line ->
			line.contains('start.chuang.ba%2Fih%2Fmtv%2Findex&response_type=code')
		}.collect{line ->
			def mat = line =~ /FromUserName\:([^\,]+)\,/
			mat[0][1]
		}

		[dat: dat, openids: openids]
	}

	ll.sort{-it.openids.size()}

	new File('openids-prd' + prdSeq + '.txt').text = JSON.toJSONString(ll.grep{it.openids.size() > 10})
}
