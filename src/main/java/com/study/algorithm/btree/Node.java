package com.study.algorithm.btree;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2019-08-27.   05:21
 * email : weiguobing@meituan.com
 */
@Data
public class Node {

	private int parent;
	private int value;
	private int left;
	private int right;

}
