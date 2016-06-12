import org.apache.http.HttpEntity
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.RequestBuilder

def article = {
	String content = new URL('http://mp.weixin.qq.com/mp/homepage?__biz=MzAwMjI2MTQyOA==&hid=1&sn=49957896db2d7ef368d3f4264d46c46f#wechat_redirect').getText('utf-8')
	String str = content.readLines().collect{it.trim()}.grep{it}.join('')

    def pat = /<a class="list_item js_post" href="([^"]+)"><div class="cover"><img class="img js_img" src="([^"]+)"
     alt=""\/><\/div><div class="cont"><h2 class="title js_title">([^<]+)<\/h2><p class="desc">([^<]+)<\/p><\/div><\/a>/

    List r = []
    println str
    def mat = str =~ pat
    mat.each{g ->
        Map item = [:]
        item.url = g[1]
        item.picurl = g[2]
        item.title = g[3]
        item.des = g[4]
        r << item
        println item
    }
}

def ape = {
	String str = '<a href="http://www.baidu.com">°Ù¶ÈÒ»ÏÂ£¬¿´¿´ÄãÀÏ°åÊÇË­£¡</a>'
	def pat = /<a href="([^"]+)">([^<]+)<\/a>/
	def mat = str =~ pat
	println mat[0][1]
	println mat[0][2]
}

def msg = {
	String con = new URL('http://mp.weixin.qq.com/s?__biz=MjM5MDQ4MzU5NQ==&mid=411357463&idx=1&sn=6c0213475e69de347a38b47ef0899722&3rd=MzA3MDU4NTYzMw==&scene=6#rd').getText('utf-8')
	List str = con.readLines()
	String lineMsgPicUrl = str.find {it.contains('msg_cdn_url')}
	if(lineMsgPicUrl) {
		def picUrlPat = /"([^"]+)"/
		def picUrlMat = lineMsgPicUrl =~ picUrlPat
		if(picUrlMat) {
			println picUrlMat[0][1]
		} else
			println 'no match'
	} 
	
	String lineMsgDesc = str.find {it.contains('msg_desc')}
	if(lineMsgDesc){
		def msgDescPat = /"([^"]+)"/
		def msgDescMat = lineMsgDesc =~ msgDescPat
		
		if(msgDescMat) {
			println msgDescMat[0][1]
		} else
			println 'no match'
	} 
}

// 公众号历史消息列表，查看访问者有没有关注公众号
def isFriend = {
	Strihttp://sq.ewemai.com/images/temp/default.jpgng viewUrl = 'http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MjM5MDE0Mjc4MA==&uin=MjA2NzgzNTIyMA%3D%3D&key=b28b03434249256ba2d2d23cbce10397105cbe902061810e8f79786d9b5f6127d6067bc3dfcd30cdcbe7a2ad9adc9520'
	String viewContent = new URL(viewUrl).getText('utf-8')
	List lines = viewContent.readLines()
	String lineIsFriend = lines.find { obj ->
		obj.contains('isFriend')
	}

	boolean isFriend = false
	if(lineIsFriend){
			def isFriendPat = /'([^']+)'/
			def isFriendMat = lineIsFriend =~ isFriendPat
			if(isFriendMat) {
				println lineIsFriend
				println isFriendMat[0][1]
				println isFriendMat
				isFriend = isFriendMat[0][1] == '1'
			} else {
				println 'not match'
			}
	}
	println isFriend
}

def pat = {
	def p2 = ~/groovy\d+/;
	println p2
	def matcher = ("hello groovy88 test" =~ p2);
	 println matcher[0]
}

HttpClient hc
def budongOnline = {
	
	String url = 'http://sq.ewemai.com/Train.aspx?t=0.707183196907863&inRecId=1461831160263?openid=otN_yspdhU4kxoidgEbaY9Kti954'
	def getNumberPost = RequestBuilder.post().setUri(new URI(url)).build()

	String headers = '''
	Host:sq.ewemai.com
	Origin:http://sq.ewemai.com
	User-Agent: Mozilla/5.0 (Linux; Android 5.1; MX5 Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036215 Safari/537.36 MicroMessenger/6.3.16.49_r03ae324.780 NetType/WIFI Language/zh_CN
	X-Requested-With:com.tencent.mm
	Referer:http://sq.ewemai.com/TeachTrainDetails.aspx?userinfo=0&inLecturerId=4614099&inRecId=1461831160263&openid=oJZrlsy_tdUmSjOIfjgds3NV_J7Q&app=0&subscribe=0&wbaccess_token=OezXcEiiBSKSxW0eoylIeA0n-vZs-Ib7N7-_pZDyFg7bAJvEq0aSqRRJv89ItTbTMOEI9KRraUu8RgaWO3iwVGFIv7uQxzb6VB_UtgP2nOuEio3NNJi_z_GJ4dj3u42UJIXDeOTi48BlvQzn5RHh6Q&refresh_token=OezXcEiiBSKSxW0eoylIeA0n-vZs-Ib7N7-_pZDyFg7bAJvEq0aSqRRJv89ItTbThXNgprNQWNNKfWQruX9DZ-apydMUaSSW5_9HCH0Wpu-c5t7XEOBWmBQR_OVIvdNd_SqNbqIjhayCmLGdmjEt8A&unionid=ofVuit5nUsCLkygQYLo-yio7_0ZE&t=0.0926960637293272
			'''
	headers.readLines().collect{it.trim()}.grep{it}.each{
		def arr = it.split(':')
		getNumberPost.setHeader(arr[0], arr[1])
	}
	println getNumberPost + '111'
	def resp = hc.execute(getNumberPost)
	HttpEntity entity = resp.getEntity()

	println entity
}

budongOnline()