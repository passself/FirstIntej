package com.cn.passself.leetcode;

public class Leet21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 非递归做法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeLink(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }

        return head.next;
    }

    /**
     * 递归做法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode megeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int v1 = l1.val, v2 = l2.val;
        ListNode node;
        if (v1 > v2) {
            node = new ListNode(v2);
            node.next = megeTwoLists(l1,l2.next);
        }else {
            node = new ListNode(v1);
            node.next = megeTwoLists(l1.next,l2);
        }
        return node;
    }
}
