package com.study.algorithm;

/**
 * 判断两个字母是不是 ：相同字母异序词
 * Created by guobing on 2016/6/26.
 */
public class ValidAnagram {

    // 是不是异序相同字母
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;

        for (int i : alphabet) if (i != 0)
            return false;

        return true;
    }

    public static void main(String [] args) {
        int[] charsMap = new int['z' - 'a' + 1];
        System.out.print(charsMap.length);
        System.out.print('z' - 'a');
    }
}
