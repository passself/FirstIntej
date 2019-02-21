package com.cn.passself.leetcode;

/**
 * 单链表反转
 * 关键:把当前节点的next指向它的前驱节点
 */
public class Leet206 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null,next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
