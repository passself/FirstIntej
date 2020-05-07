package com.cn.passself.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并K个排序链表
 */
public class Leet23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 利用堆做排序
     *
     * @param lists
     * @return 合并两个链表我们可以用if-else做判断，但是k个链接，用if-else，这就没法写了。
     * 这时候我们需要一种辅助数据结构-堆，有了堆这个数据结构，难度等级是困难的题目，瞬间变成简单了。
     * 我们把三个链表一股脑的全放到堆里面
     * <p>
     *   1->4->5
     *   1->3->4
     *   2->6
     * 然后由堆根据节点的val自动排好序
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    /**
     * 不再是一股脑全部放到堆中
     *
     * @param lists
     * @return 而是只把k个链表的第一个节点放入到堆中
     */
    public ListNode mergeKListsH(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //创建一个小根堆，并定义好排序函数
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //这里跟上一版不一样，不再是一股脑全部放到堆中
        //而是只把k个链表的第一个节点放入到堆中
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }
        //之后不断从堆中取出节点，如果这个节点还有下一个节点，
        //就将下个节点也放入堆中
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * method3
     * 两两合并
     */
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKListsTwo(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //将lists[0]作为最终合并的链表，然后将list[0]和lists[1]合并成lists[0-1]
        //再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwo(res, lists[i]);
        }
        return res;
    }

    /**
     * 分治
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsF(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = helper(lists, left, mid);
        ListNode rightNode = helper(lists, mid+1, right);
        return mergeTwo(leftNode, rightNode);
    }
}
