package com.cn.passself.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //这里只判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 用set
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head)){
                return true;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}


