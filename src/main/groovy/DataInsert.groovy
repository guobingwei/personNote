import org.paic.d.D

def d = D.gen()

	String targetOpenid = 'oeAWKwbW4odvTxnItWXeCQubCtqo'
	Map one = [id: 10, openid: targetOpenid]
	d.update(one, 'ih_comm_proj', null)
	d.exe('update ih_comm_proj set openid = ? where id = ?', [targetOpenid, 26])

//def one = d.queryMap('select * from ih_comm_proj where id = ?', [8])
//if(!one) {
//	return
//}
//println one.openid
