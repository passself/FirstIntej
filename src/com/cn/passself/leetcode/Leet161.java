package com.cn.passself.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class Leet161 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private boolean hashSolution(ListNode head) {
        Set<ListNode> set = new LinkedHashSet<>();
        while(head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    private boolean slowAndFastSolution(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            if (fast.equals(slow)){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
