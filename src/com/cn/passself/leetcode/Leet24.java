package com.cn.passself.leetcode;

/**
 * 单链表反转
 */
public class Leet24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode temp = null;
        while (head != null){
            temp = head.next;
            head.next = prev;

            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode E = new ListNode(5,null);
        ListNode D = new ListNode(4,E);
        ListNode C = new ListNode(3,D);
        ListNode B = new ListNode(2,C);
        ListNode A = new ListNode(1,B);

        /*while (A != null){
            System.out.println(A.val);
            A = A.next;
        }*/
        ListNode prev = reverseListNode(A);
        while (prev != null){
            System.out.println(prev.val);
            prev = prev.next;
        }
    }
}
