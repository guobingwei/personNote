package com.dm.yc.std.study.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public boolean uniqueOccurrences(int[] arr) {

		Map<Integer, Integer> arrCountMap = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			arrCountMap.put(arr[i], arrCountMap.getOrDefault(arr[i], 0) + 1);
		}

		Set<Integer> timeSet = new HashSet<>();
		for(Integer attr : arrCountMap.values()) {
			if(!timeSet.add(attr)) {
				return false;
			}
		}

		return arrCountMap.size() == timeSet.size();
	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		for (int value : nums1) {
			set.add(value);
		}

		Set<Integer> result = new HashSet<>();
		for(int i = 0 ; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				result.add(nums2[i]);
			}
		}
		System.out.println(set + "222");
		return result.stream().mapToInt(Integer::valueOf).toArray();
	}

	public static void main(String[] args) {
		int [] nums1 = new int[] {1,2,2,1};
		int [] nums2 = new int[] {2, 2};
		intersection(nums1, nums2);
	}
}
