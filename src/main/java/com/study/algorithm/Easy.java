package com.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2020-04-04.   09:58
 * email : weiguobing@meituan.com
 */
public class Easy {
	/**
	 * 回文字符串
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0 || (x / 10 != 0 && x % 10 == 0)) {
			return false;
		}

		int end = 0;

		while (x > end) {
			end = end * 10 + x % 10;
			x = x / 10;
		}

		return x == end || x == end / 10;
	}

	public static int romanToInt(String s) {
		int number = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			Character current = s.charAt(i);
			if (i < length -1 && getNumber(current) < getNumber(s.charAt(i+1))) {
				number -= getNumber(current);
			} else {
				number += getNumber(current);
			}
		}
		return number;
	}

	public static int getNumber(Character ch) {
		switch (ch) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		System.out.println(romanToInt("MCMXCIV"));
		System.out.println(System.currentTimeMillis() - begin);
	}
}
