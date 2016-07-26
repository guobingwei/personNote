package com.study.algorithm;

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

    // 动态规划问题
    public int climbStairs2(int n) {
        int [] res = new int[3];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i%3] = res[(i-1)%3] + res[(i-2)%3];
        }
        return res[n%3];
    }

    // 最初做法
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
}
