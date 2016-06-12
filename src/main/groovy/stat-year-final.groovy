import groovy.sql.*
import org.paic.d.D

// 一天的留存用户统计
String conf_prd = '''
com.mysql.jdbc.Driver
jdbc:mysql://start.chuang.ba:3306/innohub?useUnicode=true&characterEncoding=UTF-8
innohub
Innohub2015
'''

String conf_dev = '''
com.mysql.jdbc.Driver
jdbc:mysql://121.201.63.58:3307/innohub?useUnicode=true&characterEncoding=UTF-8
innohub
innohub2015
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

def db = getDb(conf_dev)

def changeCount = {
	def changeList = db.rows('''
		select * from ih_comm_score_change
	'''
	)

	println changeList.size()
	def maxTime = 0

	for(one in changeList) {
		one.dd = new Date(one.dd.time)
	}

	for(int i = 1; i < changeList.size(); i++) {
		def diff = changeList.get(i).dd - changeList.get(i - 1).dd
		if(diff > maxTime) {
			maxTime = diff
		}
	}

	println 'max time ' + maxTime
}

def scanEachOther = {
	List ll = []
	new File("C:/Users/guobing/Desktop/scan.txt").eachLine { line ->
		ll << line.split(/\t/)
	}

	println ll.count{
		ll.find{sub -> sub[1] == it[0] && sub[0] == it[1]} != null
	}
}

def addRole = {
	List roleList = ['普通用户', '创业教练', '超级管理员', '投资人']
	def d = D.gen()

	for(int i = 0; i < roleList.size(); i++) {
            Map r = [:]
            r.cityId = 2 ** i
            r.cityName = roleList.get(i)
            d.add(r, 'ih_bp_v2_role')
    }
}

def getRandomStr = { type ->
	def random = new Random();
	String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
	String code = type
	10.times {
		def str = chars.charAt((int)random.nextInt(62))
		code += str
	}
	println code
}

getRandomStr('BP-')