


def sso = /‘’Groovy正则表达式0-9；[]‘；“；';过滤标点符号/
def matcher = sso =~ /['’‘；“”！!;\]\[]/  //可以加入任何需要过滤的特殊字符（注意有的需要转义）
def newS = matcher.replaceAll('')
println newS