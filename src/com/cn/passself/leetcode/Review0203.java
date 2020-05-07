package com.cn.passself.leetcode;

/**
 * simple 链表操作
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * 删除中间节点
 */
public class Review0203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 删除下一节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
