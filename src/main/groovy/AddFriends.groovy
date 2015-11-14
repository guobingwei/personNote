import org.paic.d.D

def d = D.gen()

String targetOpenid = 'oeAWKwbW4odvTxnItWXeCQubCtqo'
d.exe('update ih_comm_member_friends set status = 1 where from_openid = ? or to_openid = ?', [targetOpenid, targetOpenid])

ar a = 'A'
26.times{
	char t = a + it

	3.times{j ->
		String name = '' + t + j
		String openid = name
		d.add([nickname: name, openid: openid], 'ih_wx_user')
		d.add([name: name, comp: '公司测试', position: '职位测试', openid: openid], 'ih_wx_card')
		d.add([fromOpenid: targetOpenid, toOpenid: openid, status: 1], 'ih_comm_member_friends')
		d.add([fromOpenid: openid, toOpenid: targetOpenid, status: 1], 'ih_comm_member_friends')
	}
}