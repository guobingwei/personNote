package com.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
     * Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".
 * Created by guobing on 2016/7/28.
 */
public class ReverseVowels {

    /**
     * 自己想出来的最普通的做法,代码量太多了
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        char [] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;

        List list = new ArrayList();
        list.add('a');
        list.add('e');
        list.add('o');
        list.add('i');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        while(i < j) {
            if(list.contains(ch[i]) && list.contains(ch[j])) {
                char t = ch[i];
                ch[i] = ch[j];
                ch[j] = t;
                i++;
                j--;
            } else if(list.contains(ch[i]) && !list.contains(ch[j])) {
                j--;
            } else {
                i++;
            }
        }
        return new String(ch);
    }

    public static void main(String [] args) {
        System.out.print(reverseVowelsMe("hello"));
    }


    /**
     * 网上别人写的,beats 98%.
     * 主要区别就是抛弃了list,每次查找的时间复杂度是
     * switch case 效率高多了
     * @param s
     * @return
     */
    public static boolean isVowel(char a){
        switch(a){
            case ('a') : return true;
            case ('e') : return true;
            case ('i') : return true;
            case ('o') : return true;
            case ('u') : return true;
            case ('A') : return true;
            case ('E') : return true;
            case ('I') : return true;
            case ('O') : return true;
            case ('U') : return true;
            default : return false;
        }
    }

    // beats 98%
    public static String reverseVowels1(String s) {
        if (s.length()<2) return s;

        char[] tab = s.toCharArray();
        int j = tab.length - 1;
        int i = 0;

        while( i < j ) {

            if (!isVowel(tab[i]))
                i++;
            else {
                while (j!=i && !isVowel(tab[j]))
                    j--;

                char temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                i++;
                j--;
            }
        }
        return new String(tab);
    }

    // beats 78%
    public static String reverseVowelsMe(String s) {
        char [] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if(isVowel(ch[i]) && isVowel(ch[j])) {
                char t = ch[i];
                ch[i] = ch[j];
                ch[j] = t;
                i++;
                j--;
            } else if(isVowel(ch[i]) && !isVowel(ch[j])) {
                j--;
            } else {
                i++;
            }
        }

        return new String(ch);
    }
}
