package dataSource

import groovy.sql.Sql

/**
 * Created by guobing on 2017/4/18.
 */

def sql = Sql.newInstance('jdbc:mysql://120.24.187.147:3306/major', 'major', 'major', 'com.mysql.jdbc.Driver')
println sql.connection.catalog

// select
sql.eachRow('show create table gb_boot_user') {
    println it
}

// eachRow
List list = new ArrayList();
sql.eachRow('select * from gb_boot_user') {
    printf "%-20s%s\n", it.user_id, it.name;
    list.add(it)
    print('list - ' + list)
}

// rows

test = sql.rows('select * from gb_boot_user')
println(test)

// DataSet
datSet = sql.dataSet('gb_boot_user')
filter = datSet.findAll {it.id > 10}
//println filter.size()

// insert update
println sql.rows('select * from gb_boot_user').size()
datSet.add(user_id:'1111', name:'weiguobing')
println sql.rows('select * from gb_boot_user').size()