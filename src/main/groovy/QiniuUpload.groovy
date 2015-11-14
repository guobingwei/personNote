import com.qiniu.common.QiniuException
import com.qiniu.http.Response
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth

final String ACCESS_KEY = '_2ePmFczYUPrZcpo_EBBUa4Lj24YLCOjuE_DjguO'
final String SECRET_KEY = '_nKBPEeMqLy1FNYE-glfFtDJH7s-D-pLAvdBBbsV'

String bucket = 'innohub-cm-test'
def auth = Auth.create(ACCESS_KEY, SECRET_KEY)

def upload = {String key, byte[] data, boolean replace = false ->
	String token = auth.uploadToken(bucket, key)

	def up = new UploadManager()
	def resp = up.put(data, key, token)
	if(resp.isOK()){
		println resp.bodyString()
	}
}

String path = 'G:/photo/nanpengyou.jpg'
def f = new File(path)
upload('nanpengyou.jpg', f.bytes)
