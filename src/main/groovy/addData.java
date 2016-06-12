import org.paic.d.D

def d = D.gen()

220.times{ j->
	String t = 'oeAWKwbW4odvTxnItWXeCQubCtqo' + j
	String openid =  t 
	String visit_type = 'simulation'
	d.add([visit_type: visit_type, openid: openid], 'ih_comm_stat_user_visit_20151102')
}