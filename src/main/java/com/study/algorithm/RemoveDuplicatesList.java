package com.study.algorithm;

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

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode headCopy = head;

        if(headCopy.val == next.val) {
            headCopy.next = next.next;
            return deleteDuplicates(headCopy);
        }

        return head;
    }
}
