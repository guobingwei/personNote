
import org.paic.d.D
List ll = []
new File("H:/script/bp-origin.txt").eachLine { line ->
	ll << line.split(/\t/)
}

def d = D.gen()
ll.each {one ->
	Map m = d.queryMap("select id, proj_name, status, verify_status from ih_bp_v2_detail where proj_name like '%${one[0]}%' and status=200 and verify_status=20000")
	if(m) {
		// println m
		Map r = [:]
		r.id = m.id
		r.origin = getOriginType(one[1])
		r.originRemark = one[2]
		println r
		d.update(r, 'ih_bp_v2_detail')
		println 'update ok'
	} else
		println 'not find'
}


def getOriginType(String des) {
	 String origin
        switch (des) {
            case '融资平台搜索' :
                origin = '1'
                break
            case '搜索引擎搜索' :
                origin = '2'
                break
            case '朋友推荐' :
                origin = '3'
                break
            case '微信群/图文' :
                origin = '4'
                break
            case '创大员工介绍' :
                origin = '5'
                break
            case '创业教练' :
                origin = '6'
                break
            case '微信公众号' :
                origin = '7'
                break
            case '其他' :
                origin = '8'
                break
			case '关键字搜索' :
				origin = '2'
				break
			case '中国好创业' :
				origin = '7'
				break
		
            default:
                origin = '9'
        }
        origin
}