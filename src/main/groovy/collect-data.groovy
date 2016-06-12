import org.paic.d.D
def d = D.gen()

collectDate = { date ->
		Map r = [:]
		String tableName = 'ih_comm_stat_user_visit_20160307'
        r.pv = d.queryMap("""
                select count(id) as num from ${tableName} where (visit_type = 'bp-gene-list-page' or 
				visit_type = 'bp-detail-page' or visit_type = 'bp-domain-page' or visit_type = 'bp-deliver-page' or visit_type = 'bp-admin-list-page')
                and dd >= ? and dd < ?
            """, [date, date + 1]).num

        r.uv = d.queryMap("""
                select count(distinct openid) as num from ${tableName} where (visit_type = 'bp-gene-list-page' or 
				visit_type = 'bp-detail-page' or visit_type = 'bp-domain-page' or visit_type = 'bp-deliver-page' or visit_type = 'bp-admin-list-page')
                and dd >= ? and dd < ?
            """, [date, date + 1]).num

        Map one = d.queryMap('select count(bp_id) as num from ih_bp_v2_detail where status = ? and dd >= ? and dd < ?', [200, date, date + 1])
        r.bpNum = one.num ?: 0

        Map deliOne = d.queryMap('select count(bp_id) as num from ih_bp_v2_detail where status = ? and owner_openid is not null and dd >= ? and dd < ?', [200, date, date + 1])
        r.deliByOwner = deliOne.num ?: 0

        Map tuOne = d.queryMap('select count(bp_id) as num from ih_bp_v2_detail where status = ? and tutor_openid is not null and dd >= ? and dd < ?', [200, date, date + 1])
        r.deliByTutor = tuOne.num ?: 0

		String dayLabel = date.format('yyyy-MM-dd')
        r.dayLabel = dayLabel
        println "queryMap --------------------------" + r
		
		Map old = d.queryMap('select * from ih_bp_v2_data_stat where day_label = ?', [dayLabel])
		println 'old--------------------------' + old
        if(old && old.id) {
            r.id = old.id
            r.updateTime = date.getTime()
			r.dd = date
			println 'update r ------------------------' + r
            d.update(r, 'ih_bp_v2_data_stat')
        } else {
			r.dd = date
			println 'add one r ------------------++++++++++++++++++' + r
		
            d.add(r, 'ih_bp_v2_data_stat')
        }
}

	Date begd = Date.parse('yyyy-MM-dd', '2016-03-07')
	Date endd = Date.parse('yyyy-MM-dd', '2016-03-11')

	(endd - begd).times {
		collectDate(begd + it)
	}
