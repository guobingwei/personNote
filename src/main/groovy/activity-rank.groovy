import org.paic.d.D
import com.alibaba.fastjson.JSON
import com.qiniu.common.QiniuException
import com.qiniu.http.Response
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth

final String ACCESS_KEY = '_2ePmFczYUPrZcpo_EBBUa4Lj24YLCOjuE_DjguO'
final String SECRET_KEY = '_nKBPEeMqLy1FNYE-glfFtDJH7s-D-pLAvdBBbsV'
// TODO test
String bucket = 'innohub-cm'
def auth = Auth.create(ACCESS_KEY, SECRET_KEY)

def upload = {String key, byte[] data ->
	String token = auth.uploadToken(bucket, key)

	def up = new UploadManager()
	def resp = up.put(data, key, token)
	if(resp.isOK()){
		println resp.bodyString()
	}
}
String pre = 'http://start.chuang.ba/ih/test'
def updateMediaId = {int id ->
	def d = D.gen()

	def item = d.queryMap('select * from ih_rank_candi_general where id = ?', [id])
	
	String fileName = item.id + item.name + '.jpg'
	String key = item.id + '-guangzhou-vote.jpg'

	String filePath = 'H:/activity/post/' + fileName
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
	println mediaId
	if(!mediaId){
		println 'mediaId not get - ' + resultText
		return
	}

	d.update([id: id, mediaId: mediaId], 'ih_rank_candi_general')
	println 'done update media id ' + mediaId + ' 4 ' + id
}


updateMediaId(7)

