package com.study.algorithm;

/**
 * 位图运算
 * 海量数据中寻找某个数是否存在 布隆过滤器
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2020-09-18.   17:30
 * email : weiguobing@meituan.com
 */
public class BitMap {

	private char[] bytes;
	private int nbits;

	public BitMap(int nbits) {
		this.nbits = nbits;
		this.bytes = new char[nbits/16+1];
	}

	public void set(int k) {
		if (k > nbits) return;
		int byteIndex = k / 16;
		int bitIndex = k % 16;
		bytes[byteIndex] |= (1 << bitIndex);
	}

	public boolean get(int k) {
		if (k > nbits) return false;
		int byteIndex = k / 16;
		int bitIndex = k % 16;
		return (bytes[byteIndex] & (1 << bitIndex)) != 0;
	}

	/**
	 * 将数字 A 的第 k 位设置为1：A = A | (1 << (k - 1))
	 * 将数字 A 的第 k 位设置为0：A = A & ~(1 << (k - 1))
	 * 检测数字 A 的第 k 位：A & (1 << (k - 1)) != 0
	 * 用于理解bitmap中代码
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BitMap bitMap = new BitMap(32);
		bitMap.set(7);
		System.out.println(bitMap.get(7));
	}
}
