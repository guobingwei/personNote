package com.study.algorithm;

/**
 * 位图运算
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

	public static void main(String[] args) {
		BitMap bitMap = new BitMap(32);
		bitMap.set(16);
		System.out.println(bitMap.get(16));
	}
}
