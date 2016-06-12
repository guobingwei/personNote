import org.paic.d.D

List userTaglist = ['二次元达人', '屌丝', '青少年', '女性', '男性', '母婴', '儿童', '学生', '海外市场']
    List indusTagList = ['电子商务', '房产', '工具软件', '广告营销', '互联网金融', '教育', '旅游', '媒体', '汽车',
                         '社交', '体育运动', '文化娱乐', '医疗', '健康', '硬件', '游戏动漫', '地产', '企业级应用/服务',
                         '家居', '服饰鞋帽箱包', '餐饮', '生活服务', '美容', '孕产育儿', '政法']
    List patternTaglist = ['B2B', 'O2O', '2B', '2C', '电商平台', '技术创新', '内容聚合', '众筹']
    List teamTaglist = ['BAT系', '搜狐系', '网易系', '海归', '70后', '80后', '90后', '连续创业者', '线下能力强', '500强出身', '学生', '程序员出身' , '产品出身', '设计出身', '运营出身', '投资人出身', '政府背景']
    List cityList = ['北京', '上海', '广州', '杭州', '深圳', '青岛', '武汉', '佛山', '珠海', '成都', '其他']
    List roleList = ['普通用户', '创业教练', '超级管理员', '投资人']

def addTagByType(List targetList, int type) {
    def d = D.gen()
    for(int i = 0; i < targetList.size(); i++) {
        Map r = [:]
        r.tagId = 2 ** i
        r.tagDes = targetList.get(i)
        r.type = type
        d.add(r, 'ih_bp_v2_tag')
        println r
    }
}

def addCity(List cityList) {
    
    def d = D.gen()
    for(int i = 0; i < cityList.size(); i++) {
        Map r = [:]
        r.cityId = 2 ** i
        r.cityName = cityList.get(i)
        d.add(r, 'ih_bp_v2_city')
        println r
    }
}

def addRole(List rList) {
    def d = D.gen()
    for(int i = 0; i < rList.size(); i++) {
        Map r = [:]
        r.roleId = 2 ** i
        r.roleDes = rList.get(i)
        d.add(r, 'ih_bp_v2_role')
        println r
    }
}

def addTagInfo = {
    addTagByType(userTaglist, 1)
    addTagByType(indusTagList, 3)
    addTagByType(patternTaglist, 4)
    addTagByType(teamTaglist, 2)
    addCity(cityList)
    addRole(roleList)
}

addTagInfo().call()