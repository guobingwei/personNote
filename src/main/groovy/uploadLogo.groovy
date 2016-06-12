import org.paic.d.D
import com.qiniu.common.QiniuException
import com.qiniu.http.Response
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth


	final String ACCESS_KEY = '_2ePmFczYUPrZcpo_EBBUa4Lj24YLCOjuE_DjguO'
	final String SECRET_KEY = '_nKBPEeMqLy1FNYE-glfFtDJH7s-D-pLAvdBBbsV'

	String bucket = 'innohub-cm'
	def auth = Auth.create(ACCESS_KEY, SECRET_KEY)

	String qiniuUrlPre = 'http://7xjceh.com2.z0.glb.qiniucdn.com/'

	def upload = {String key, byte[] data, boolean replace = false ->
		String token = auth.uploadToken(bucket, key)

		def up = new UploadManager()
		def resp = up.put(data, key, token)
		if(resp.isOK()){
			println resp.bodyString()
		}
	}

	def d = D.gen()

	def files = new File('H:/activity/logo').listFiles()

def uploadLogo = {int id ->
	def item = d.queryMap('select * from ih_rank_candi_general where id = ?', [id])
	
	if(!item || item.logoPath)
		return
	def targetFile = files.find{it.name.contains(item.name)}
	if(!targetFile){
		println 'no file found ' + item.name
		return
	}

	upload(targetFile.name, targetFile.bytes)	
	d.update([id: item.id, logoPath: qiniuUrlPre + targetFile.name], 'ih_rank_candi_general')

}

(1..55).each {
	uploadLogo(it)
}
