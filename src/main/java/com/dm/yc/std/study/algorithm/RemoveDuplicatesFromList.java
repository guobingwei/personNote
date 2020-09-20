package com.dm.yc.std.study.algorithm;

/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
 * Created by guobing on 2016/7/26.
 */
public class RemoveDuplicatesFromList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 递归的做法
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        if(head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
            head = deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    // 非递归，循环的做法
    public ListNode deleteDuplicate(ListNode head) {
        ListNode list = head;
        while(list != null) {
            if(list.next == null) {
                break;
            }

            if(list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }

    // 爬楼梯 动态规划问题
    public int climbStairs2(int n) {
        int [] res = new int[3];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i%3] = res[(i-1)%3] + res[(i-2)%3];
        }
        return res[n%3];
    }

    // 爬楼梯 最基本做法
    public int climbStairs(int n) {
        if(n == 0|| n == 1 || n == 2){
            return n;
        }

        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for(int i = 3; i <= n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    // 算买入股票的最佳收益问题
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        if(size < 2) {
            return 0;
        }
        int min = prices[0];
        int max = prices[1];

        for(int i = 1; i < size; i++) {
            if((min > prices[i]) && (i < size -1)) {
                min = prices[i++];
                max = prices[i];
            }

            if(max < prices[i]) {
                max = prices[i];
            }
        }

        return (max - min) > 0 ? (max - min) : 0;
    }

    public static void main(String [] args) {
        int [] stack = {7,6,4,3,1};
        maxProfit(stack);
    }

    // 算买入股票的最佳收益问题
    public int maxProfit1(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int min = prices[0],result = 0;
        for (int i = 1;i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                result = Math.max(result, prices[i] - min);
            else min = Math.min(min, prices[i]);
        }
        return result;
    }

}
