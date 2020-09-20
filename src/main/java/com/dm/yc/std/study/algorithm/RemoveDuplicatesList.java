package com.dm.yc.std.study.algorithm;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Created by guobingwei on 2016/6/28.
 */
public class RemoveDuplicatesList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        int val = head.val;
        ListNode next = head.next;
        if(next.val != val){
            head.next = deleteDuplicates(next);
            return head;
        }else{
            while(next != null && next.val == val) {
                next = next.next;
            }
            return deleteDuplicates(next);
        }
    }

    /***
     * 非递归，用循环解决
     */
    public void deleteDuplicateByLoop(ListNode head) {

    }
}
