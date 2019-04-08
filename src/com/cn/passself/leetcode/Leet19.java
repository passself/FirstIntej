package com.cn.passself.leetcode;


/**
 *
 */
public class Leet19 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        /*while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }*/

        ListNode result = removeNthFromEnd2(head,2);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 计数法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (count == n) {
            return head.next;
        }

        if (count > n) {
            int target = count - n;
            ListNode newH = head;
            for (int j = 1; j < target; j++) {
                newH = newH.next;
            }
            newH.next = newH.next.next;
        }
        return head;
    }

    /**
     * 双指针，不太理解
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null){
            return head.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
