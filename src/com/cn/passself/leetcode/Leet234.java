package com.cn.passself.leetcode;

/**
 * 回文链表
 */
public class Leet234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //方法一
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseListNode(slow.next);
        while (slow != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = null ,temp = null;
        while (head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    //方法2
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode a = head;
        int n = 0;

        while (a != null){
            a = a.next;
            n++;
        }
        n = n/2;
        a = head;
        for (int i = 0; i < n; i++) {
            a = a.next;
        }
        ListNode pre = null;
        ListNode cur = a;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        for (int i = 0; i < n; i++) {
            if (head.val == pre.val){
                head = head.next;
                pre = pre.next;
            }else{
                return false;
            }
        }
        return true;
    }

    //方法3 https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51383256

}
