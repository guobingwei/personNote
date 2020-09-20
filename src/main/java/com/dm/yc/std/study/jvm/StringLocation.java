package com.dm.yc.std.study.jvm;

/**
 * Created by guobing on 2016/8/23.
 */
public class StringLocation {

    /***
     * 该示例考察的是“+”号的用法，只需记住“+”号两边只要有非对象池中的字符串
     * 对象那么必然会在内存中创建新对象，如：s4 = s1 + s2是两个应用再做拼接
     * 那么会直接在内存中创建值为"abcd"的对象，s6 = new String("ab") + "cd"
     * 也是同理。那么，只有在“+”号两侧对象都是字面上的字符串时才会从池子中查找，
     * 如：s3 = "ab" + "cd"，“+”号两侧的对象都是对象池中的对象，二者拼接后依旧在对象池中查找。
     * @param args
     */
    public static void main(String [] args) {

        String s1 = "abc";
        String s2 = "ab";
        String s3 = "c";
        String s4 = "ab" + "c";
        String s5 = s2 + s3;
        System.out.println(s1 == s4); // true
        System.out.println(s1 == s5); // false
    }
}
