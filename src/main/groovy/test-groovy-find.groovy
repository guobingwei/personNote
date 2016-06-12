import org.paic.d.D

def testGroovyFind = {
	def list = [5, 10, 15, 20, 25, 30]
	def result = list.find { it > 10 }
	println result
}

def getCityId(String cityName) {
	def d = D.gen()
	println '++++++++++++++++++++++' + cityName
	
	def ll = d.query('select * from ih_bp_v2_city')
	
	println '-------------------------' + ll
	
	def city = ll.find {it.cityName == cityName}
	
	println '-------------------- ' + city
	
	if(!city && !city.cityId) {
		def cityO = d.queryMap('select max(city_id) as city_id from ih_bp_v2_city')
		println 'get max cityId - ' + cityO
		int cityId = cityO.cityId * 2
		println 'get city id - ' + cityId
		//d.add([cityId: cityId, cityName: cityName], 'ih_bp_v2_city')
		return cityId
	}
	
	return city.cityId
}

def test = {
	def c = getCityId('π„÷›')
	println 'end' + c
}

test()
