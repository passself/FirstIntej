package com.cn.passself.leetcode;
import	java.util.Stack;


/**
 * 两数相加II
 * 用两个栈保存又变成了两个数相加问题
 */
public class Leet445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer> ();
        Stack<Integer> stack2 = new Stack<Integer> ();
        ListNode node1 = l1;
        while (node1 != null){
            stack1.push(node1.val);
            node1 = node1.next;
        }
        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry !=0){
            int result = 0;
            if (!stack1.isEmpty())
                result += stack1.pop();
            if (!stack2.isEmpty())
                result += stack2.pop();
            result+=carry;
            ListNode node = new ListNode(result%10);
            carry = result / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}
