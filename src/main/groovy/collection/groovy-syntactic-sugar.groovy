/**
 * Created by guobing on 2016/7/30.
 */

// groovy list join : 把所有的元素组成一个字符串
List list = [1, 3, 4, 5, 5, 5, 7, 1, 2]
def result = list.join()
println result

// groovy list grep : 根据某个条件筛选
def grepResult = list.grep{it > 2}
println grepResult

// groovy list collect : 对集合每个元素进行运算后,得到一个新集合
def colResult = list.collect {it * 2}
println colResult


