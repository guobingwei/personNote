import java.security.Security;
import javax.mail.* 

final String POP3Host = '10.33.111.151'
final String userName = 'dingyong018@paic.com.cn'
final String pwd = 'HI123hello'

Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider())
def prop = System.getProperties()
prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
prop.setProperty("mail.pop3.socketFactory.fallback", "false")
prop.put("mail.pop3.host", POP3Host)
prop.put("mail.imap.starttls.enable", "true")
prop.put("mail.debug", "true")
prop.setProperty("mail.pop3.port ", "995")
prop.setProperty("mail.pop3.socketFactory.port", "995")

def auth = [
	getPasswordAuthentication : {
		new PasswordAuthentication(userName, pwd)
	}
] as Authenticator
def s = Session.getDefaultInstance(prop, auth)
def store = s.getStore("pop3")  
store.connect(POP3Host, userName, pwd) 

Folder folder = store.getFolder("Inbox")  
folder.open(Folder.READ_ONLY) 

FetchProfile profile = new FetchProfile()  
profile.add(FetchProfile.Item.ENVELOPE) 
Message[] arr = folder.getMessages()
folder.fetch(arr, profile) 

println "收件箱的邮件数：" + arr.length  

folder.close(false) 
store.close()