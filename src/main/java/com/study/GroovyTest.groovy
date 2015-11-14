package com.study

/**
 * Created by guobing on 2015/11/13.
 */
class GroovyTest {

    static boolean main(args) {
        //servie()
        closure()
    }

    static void servie() {
        new File('G:/files/aa.txt').eachLine {println it}
    }

    static void closure() {
//       def log = ''
//        (1..10).each {log += it}
//        assert log == '123456789'
        def a = 'coffee'
        def b = {
            def c = 'tea'
            a + ' and ' + c
        }

        assert b() == 'coffee and tea'

        def c = {it * 4; print it}
        print c
        c('run') == 'runrunrun'
    }

}
