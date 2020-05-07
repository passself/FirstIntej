package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 移除重复节点
 */
public class Review0201 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode later = null;
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (prev != null) {
            if (!hashMap.containsKey(prev.val)) {
                hashMap.put(prev.val, 1);
                later = prev;
                prev = prev.next;
            } else {
                prev = prev.next;
                later.next = prev;
            }
        }
        return head;
    }

    public static ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode later = new ListNode(0);
        later.next = head;

        Set<Integer> set = new HashSet<>();
        while (pre != null) {
            if (!set.contains(pre.val)) {
                set.add(pre.val);
                later = pre;
            } else {
                later.next  = pre.next;
            }
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(removeDuplicateNodes2(head));
    }
}
