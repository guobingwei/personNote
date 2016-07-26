/**
 * Created by guobing on 2016/7/14.
 */
/*


import groovy.util.Eval

assert Eval.me('33*3') == 99
assert Eval.me('"foo".toUpperCase()') == 'FOO'

def shell = new GroovyShell()
def result = shell.evaluate '3*5'
def result2 = shell.evaluate(new StringReader('3*5'))
assert result == result2
def script = shell.parse '3*5'
assert script instanceof groovy.lang.Script
assert script.run() == 15*/
def cl = this.class.classLoader
while (cl) {
    println cl
    cl = cl.parent
}