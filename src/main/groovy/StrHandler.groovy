String str = 'ihoa, jfkds, fkjsdjfks,  fsdjkfjksdjk,,'
int id = str.lastIndexOf(',')
println id
str = str[0..-3]
println str

def list = []
3.times { i ->
	Map one = [:]
	one.name = 'wei' + i
	one.age = 24
	list << one
}

list.remove {
	boolean flag = false
	if(it.name != null) {
		flag = true
	}
	!flag
}

println list

def tag = {
	t('a', 1)
}

def t(String a, int b) {
	println a + ' - ' + b
}

tag.call()