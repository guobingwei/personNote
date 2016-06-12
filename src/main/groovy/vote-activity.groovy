// 为项目投票活动生成数据
import org.paic.d.D
import com.alibaba.fastjson.JSON

String str = '''Braeco（杯口）智慧餐厅管理平台'''

List ll = str.readLines().collect{it.trim()}.grep{it}
Map one = [:]
one.name = ll[0]


def updateRow = {
	def d = D.gen()
	def row = d.queryMap("""
		select * from ih_rank_candi_general where name = ?
	"""
	, [one.name])
	if(!row){
		one.id = d.add(one, 'ih_rank_candi_general')
	}else{
		one.id = id
		d.update(one, 'ih_rank_candi_general')
	}
	println 'done update row ' + one
}

// TODO
String pre = 'http://start.chuang.ba/ih/test'
def updateTicket = {int id ->
	def d = D.gen()
	Map row = d.queryMap("select ticket from ih_rank_candi_general where id = ?", [id])
	if(!row){
		println 'row not exist ' + id  
		return
	}
	if(!row.ticket){
		String resultText = new URL(pre + '/wx-qr-url?key=vote-proj-' + id).text
		def result = JSON.parse(resultText)
		String ticket = result.ticket
		if(!ticket){
			println 'ticket not get - ' + resultText
			return
		}

		d.update([id: id, ticket: ticket], 'ih_rank_candi_general')
		println 'done update ticket ' + ticket + ' 4 ' + id
	}
}


def updateMediaId = {int id ->
	String key = 'proj-post-' + id + '.jpg'
	String filePath = 'C:/tmp/' + key
	def file = new File(filePath)

	if(!file.exists()){
		println 'file not exists ' + key
		return
	}

	// upload to qiniu
	upload(key, file.bytes)
	String resultText = new URL(pre + '/upload?key=' + key).text
	def result = JSON.parse(resultText)
	String mediaId = result.media_id
	if(!mediaId){
		println 'mediaId not get - ' + resultText
		return
	}

	def d = D.gen()
	d.update([id: id, mediaId: mediaId], 'ih_rank_candi_general')
	println 'done update media id ' + mediaId + ' 4 ' + id
}

//updateRow()
updateTicket(55)
//(26..48).each{
//	updateTicket(it)
//}

//updateMediaId(1)