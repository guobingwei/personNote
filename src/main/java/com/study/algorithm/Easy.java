package com.study.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

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

	/**
	 * 罗马数字转阿拉伯数字
	 *
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		int number = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			Character current = s.charAt(i);
			if (i < length - 1 && getNumber(current) < getNumber(s.charAt(i + 1))) {
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

	/**
	 * 求最长公共前缀
	 *
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length <= 0) {
			return "";
		}

		String first = strs[0];
		for (int i = 1; i < strs.length; i++) {

			while (strs[i].indexOf(first) != 0) {
				first = first.substring(0, first.length() - 1);
			}
		}
		return first;
	}

	/**
	 * 求最长公共字符
	 *
	 * @param strs
	 * @return
	 */
	public static String longestCommon(String[] strs) {
		if (strs.length <= 0) {
			return "";
		}

		String first = strs[0];
		for (int i = 1; i < strs.length; i++) {

			while (!strs[i].contains(first)) {
				first = first.substring(0, first.length() - 1);
			}
		}
		return first;
	}

	// "[]({})(([]){})"

	public static boolean isValid(String s) {
		if (s.length() <= 0) {
			return true;
		}

		while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
			s = s.replace("{}", "");
			s = s.replace("[]", "");
			s = s.replace("()", "");
		}
		return s.equals("");
	}

	public static boolean isValidByStack(String s) {

		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if ('{' == c) {
				stack.push('}');
			} else if ('(' == c) {
				stack.push(')');
			} else if ('[' == c) {
				stack.push(']');
			} else if (stack.isEmpty() || c != stack.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static Character getReverse(Character source) {
		switch (source) {
			case '{':
				return '}';
			case '[':
				return ']';
			case '(':
				return ')';
			default:
				return 'u';
		}
	}

	public static void main(String[] args) {
		String s = "[]({})(([]){})";
		System.out.println(isValidByStack(s));
	}
}
