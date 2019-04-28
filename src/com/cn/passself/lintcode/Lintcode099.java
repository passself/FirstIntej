package com.cn.passself.lintcode;

import com.cn.passself.effect.Stack;

/**
 * https://www.lintcode.com/problem/reorder-list/description
 * 重排链表
 */
public class Lintcode099 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void recordList(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode middleNode = findMiddle(head);
        ListNode after = reverse(middleNode.next);
        middleNode.next = null;
        merge(head,after);
    }

    public void merge(ListNode front,ListNode after){
        int index = 0;
        ListNode result = new ListNode(0);
        while (front != null && after!= null){
            if (index % 2 == 0 ){
                result.next = front;
                front = front.next;
            }else {
                result.next = after;
                after = after.next;
            }
            result = result.next;
            index ++;
            if (front == null){
                result.next = after;
            }
            if (after == null){
                result.next = front;
            }
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    /**
     * 找中点
     * @param head
     * @return
     */
    public ListNode findMiddle(ListNode head){
        ListNode slow = head,fast = head.next;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void recordList2(ListNode head){
        if (head ==null){
            return;
        }
        ListNode newHead = head;
        Stack<ListNode>   stack = new Stack<>();
        int count = 0;
        while (newHead != null){
            count++;
            stack.push(newHead);
            newHead = newHead.next;
        }
        newHead = head;

        for (int i = 0; i <= count / 2; i++) {
            if (i==count/2){
                newHead.next = null;
                break;
            }
            ListNode tmp = reverse(newHead);
            newHead = tmp;
        }
    }
}
