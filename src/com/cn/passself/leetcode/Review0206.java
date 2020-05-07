package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * 回文链表
 */
public class Review0206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head){
        if (head == null){
            return true;
        }

        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;

        boolean palindrome = true;

        while(palindrome && curr2 != null){
            if (curr1.val != curr2.val) palindrome = false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return palindrome;
    }

    public ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;

            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }
}
