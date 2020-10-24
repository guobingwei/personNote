package com.dm.yc.std.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2020-09-28.   08:20
 * email : weiguobing@meituan.com
 */
public class PaiDui {

	public static int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});

		List<int[]> list = new ArrayList<>();
		for (int[] p : people) {
			list.add(p[1], p);
		}
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
		int [][] people =  {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

//		reconstructQueue(people);

//		Stream<int[]> sorted = Arrays.stream(people).sorted(Comparator.comparingInt(p -> p[0]).reversed());

		int [] temp = {1, 2,4, 5,6};
	}
}
