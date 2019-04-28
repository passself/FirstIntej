package com.cn.passself.algorithm;

/**
 * 链表相关
 *
 * 链表操作的时候需要检查:
 * 1.如果链表是空的时候，代码能否正常工作
 * 2.如果链表只包含一个节点的时候
 * 3.如果链表只包含两个节点的时候
 * 4.代码逻辑在处理头节点和尾节点的时候
 *
 */
public class LinkNode {

    public static void main(String[] args) {
        Node node0 = new Node(null,0);
        Node node1 = new Node(node0,1);
        Node node2 = new Node(node1,2);
        Node node3 = new Node(node2,3);
        Node node4 = new Node(node3,4);

        Node head = reverseNode(node4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

        Node newNode = new Node(null,9);

        Node node3Next = node3.next;
        node3.next = newNode;
        newNode.next = node3Next;

        Node newLink = node4;
        while (newLink != null){
            System.out.println("new--"+newLink.val);
            newLink = newLink.next;
        }
    }

    public static Node reverseNode(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node next,prev = null;

        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
