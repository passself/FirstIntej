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


    public boolean isPalindrome3(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head,fast = head;
        ListNode pre = head,prepre = null;
        while(fast != null && fast.next.next!= null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //如果fast为null , 说明是奇数，需要再进一位
        if (fast != null){
            slow = slow.next;
        }
        //此时pre 为反转原链表前半部分的子链
        //slow 为原链表的中间节点
        while(pre != null && slow != null){
            if (pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
    //方法4
    public boolean isPalindrome4(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        // 如果 fast 不为 null，说明是奇数，需要再进一位
        if(fast != null) {
            slow = slow.next;
        }
        // 此时 pre 为反转原链表前半部分的子链表
        // slow 为原链表的中间节点
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
