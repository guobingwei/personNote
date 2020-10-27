package com.dm.yc.std.study.algorithm.tree;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2020-10-25.   11:18
 * email : weiguobing@meituan.com
 */
public class KeybordTest {
	public char slowestKey(int[] releaseTimes, String keysPressed) {

		char result = 0;
		int max = 0;
		char[] chars = keysPressed.toCharArray();
		for(int i = 1; i<releaseTimes.length; i++) {
			int temp = releaseTimes[i] - releaseTimes[i-1];
			if (temp > max) {
				max = temp;
				result = chars[i];

			} else if(temp == max) {
				if (result < chars[i]) {
					result = chars[i];
				}
			}
		}

		return result;
	}
}
