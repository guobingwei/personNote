package com.study.algorithm;

/**
 * Created by guobing on 2016/7/27.
 */
public class linkListCycle {
    public static void main(String [] args) {

    }

    class ListNode {
        ListNode next;
        int val;
    }

    /**
     * 判断一个链表是否有环
     * 思路：用两个增长幅度不同的指针去访问链表，如果相交则有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }
}
