package com.cn.passself.leetcode;


/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Leetcode203 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x,ListNode next) { val = x; this.next = next;}
    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head != null && head.val ==val){
            head =  head.next;
        }
        if(head==null)
            return head;
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static ListNode removeElements3(ListNode head, int val){
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return head;
        ListNode prev=head;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return head;
    }


    public static ListNode removeElements2(ListNode head,int val){
        ListNode newHead=new ListNode(val-1,head);
        ListNode prev = newHead;

        while (prev.next != null){
            if(prev.next.val ==val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode F = new ListNode(6,null);
        ListNode E = new ListNode(3,F);
        ListNode D = new ListNode(4,E);
        ListNode C = new ListNode(3,D);
        ListNode B = new ListNode(2,C);
        ListNode A = new ListNode(1,B);
        ListNode result = removeElements(A,3);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
