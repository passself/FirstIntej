package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * 链表相交
 */
public class Review0207 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路：双指针法。一个指针指向A链表，一个指向B链表。如果相遇则返回，否则没有交点。
        //如果存在相交结点，那么pA和pB一定会相遇。
        if (headA == null || headB == null){
            return null;
        }

        ListNode prevA = headA, prevB = headB;

        while(prevA != prevB){
            prevA = prevA == null ? headB:prevA.next;
            prevB = prevB == null ? headA:prevB.next;
        }
        return prevA;
    }
}
