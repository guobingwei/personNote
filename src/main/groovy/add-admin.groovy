import org.apache.commons.codec.digest.DigestUtils	
import org.paic.d.D
import service.bpv2.BpUtilsService

def addAdmin = {
	Map one = [:]
    one.name = 'admin'
    one.pwd = '1234'
    one.roleId = 4
    one.userId = BpUtilsService.getUniqueStr('U-')
    one.pwd = DigestUtils.md5Hex(one.pwd)
    def d = D.gen()
    d.add(one, 'ih_bp_v2_admin_count')
	println one
}

addAdmin()