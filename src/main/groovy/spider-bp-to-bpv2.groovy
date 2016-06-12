import org.paic.d.D
import com.alibaba.fastjson.JSON
def insertTo = {
	def d = D.gen()
	def ll = d.query('select * from ih_bp_collect where id <25')
	int bpId
	ll.each { one ->
		List list = []
		Map r = [:]
		r.bpType = 'pl'
		bpId = getId('bpId')
		r.bpId = bpId
		r.src_id = one.srcId
		r.cityId = getCityId(one.addr)
		r.verifyStatus = 30000
		Map temp = [:]
		temp = JSON.parse(one.info)
		println '--------------------------------' + temp.name
		r.projName = temp.name ? temp.name : ''
		r.des = temp.des ? temp.des : ''
		if(one.website && one.website == 'ttt') {
			r.website = '天天投'
		}
		if(temp && temp.tagInfo)  {
			Map fin = temp.tagInfo
			if(fin['融资阶段']) {
				def tempStr = fin['融资阶段']
				if(tempStr == 'Pre-A') {
					r.lastFinanceRounds = '3p'
				}else if(tempStr == '天使轮') {
					r.lastFinanceRounds = '2'
				} else if(tempStr == '种子轮') {
					r.lastFinanceRounds = '6'
				} else if(tempStr == 'A轮') {
					r.lastFinanceRounds = '3'
				} else if(tempStr == 'B轮') {
					r.lastFinanceRounds = '4'
				} else if(tempStr == 'C轮') {
					r.lastFinanceRounds = '5'
				}
			}
		}
		list = temp.teamMemberLl
		println '------------------------------------------' + temp.teamMemberLl
		d.add(r, 'ih_bp_v2_detail')
		println 'add to detail ----------------------------------------------------------------------------------------- ' + r
		
		list.each { mOne ->
			Map mr = [:]
			mr.name = mOne.title ? mOne.title : ''
			mr.position = mOne.name ? mOne.name : ''
			mr.experience = mOne.des ? mOne.des :  ''
			mr.bpId = bpId
			d.add(mr, 'ih_bp_v2_team_member')
			println 'add to team member ----------------------------------------------------------------------------- ' + mr
		}
	}
}

// get bpId
def getId(String idName) {
	def d = D.gen()
    Map r = d.queryMap("select _nextval(?) as id", [idName]);
    println 'get bpId - ' + r.id
    r.id
}

def getCityId(String cityName) {
	def d = D.gen()
	def ll = d.query('select * from ih_bp_v2_city')
	
	def city = ll.find {it.cityName == cityName}
	
	if(!city && !city.cityId) {
		def cityO = d.queryMap('select max(city_id) as city_id from ih_bp_v2_city')
		println 'get max cityId - ' + cityO
		int cityId = cityO.cityId * 2
		println 'get city id - ' + cityId
		d.add([cityId: cityId, cityName: cityName], 'ih_bp_v2_city')
		return cityId
	}
	
	println '++++++++++++++++++++++++++++++++find-' + city.cityId
	
	return city.cityId
}


insertTo()












