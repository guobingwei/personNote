import groovy.sql.*
import com.alibaba.fastjson.JSON

String conf1 = '''
com.mysql.jdbc.Driver
jdbc:mysql://121.201.63.58:3306/innohub?useUnicode=true&characterEncoding=UTF-8
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
def ll = db.rows("select * from ih_wx_card where comp like '%创大%'")
println 'size - ' + ll.size()
db.close()

def sb = new StringBuilder()

for(user in ll){
sb << """
BEGIN:VCARD
VERSION:3.0
N:A ${user.name}
TEL:${user.tel}
ORG:创大
TITLE:${user.position}
END:VCARD
"""
}

new File('innohub.vcf').setText(sb.toString(), 'gbk')