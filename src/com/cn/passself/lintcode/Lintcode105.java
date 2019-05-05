package com.cn.passself.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/copy-list-with-random-pointer/description
 * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
 *
 * 返回一个深拷贝的链表。
 */
public class Lintcode105 {

    class RandomListNode{
        int label;
        RandomListNode next,random;
        RandomListNode(int x){this.label = x;}
    }

    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode node = head;
        Map<RandomListNode,RandomListNode> cache = new HashMap<>();
        while (node!= null){
            RandomListNode copyNode = new RandomListNode(node.label);
            cache.put(node,copyNode);
            node = node.next;
        }

        for (RandomListNode n: cache.keySet()) {
            cache.get(n).next = cache.get(n.next);
            cache.get(n).random = cache.get(n.random);
        }

        return cache.get(head);
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 不使用hashmap
     * 三次遍历
     * **
     *         +--+
     * src:    1->2->3
     *
     *
     * step1: copy node
     *         +------+
     * src:    1->1'->2->2'->3->3'
     *
     *
     * step2: copy random link
     *         +------+
     * src:    1->1'->2->2'->3->3'
     *            +------+
     *
     *
     * step3: split two lists
     *         +--+
     * src:    1->2->3
     *
     *         +---+
     * dst:    1'->2'->3'
     *
     */

    public RandomListNode copyRandomListNew(RandomListNode head){
        RandomListNode temp = null,start = head;
        if (head == null){
            return null;
        }

        //1
        while (head != null){
            temp = head.next;
            head.next = new RandomListNode(head.label);
            head.next.next = temp;
            head = temp;
        }
        //2
        head = start;
        RandomListNode fast = head.next;
        while (head != null){
            RandomListNode distemp = head.random;
            if (distemp != null){
                fast.random = distemp.next;
            }else {
                fast.random = null;
            }

            head = fast.next;
            if (head != null){
                fast = head.next;
            }
        }
        //3
        RandomListNode dummy = new RandomListNode(0),tail = dummy;
        head = start;
        while (head != null){
            RandomListNode copyNode = head.next;
            head.next = copyNode.next;
            tail.next = copyNode;
            tail = copyNode;
            head = head.next;
        }
        return dummy.next;
    }

}
