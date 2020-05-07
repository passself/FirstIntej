package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Leet02 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1;
        ListNode q = l2;

        int addNum = 0;

        while (q != null){
            if (p.next == null && q.next != null){
                p.next = new ListNode(0);
            }
            if (p.next != null && q.next == null){
                q.next = new ListNode(0);
            }
            int sumAll = addNum + p.val + q.val;
            p.val = sumAll%10;
            addNum = sumAll/10;
            if (p.next == null && q.next == null && addNum!=0){
                p.next = new ListNode(addNum);
            }
            p = p.next;
            q = q.next;
        }
        return l1;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null) l1 = new ListNode(0);
        l1.val += l2 == null ? 0: l2.val;
        if(l1.val > 9){
            l1.val = l1.val % 10;
            if(l1.next == null)
                l1.next = new ListNode(1);
            else
                l1.next.val +=1;
            l1.next = addTwoNumbers(l1.next,l2 == null ? null : l2.next);
        }else{
            l1.next = addTwoNumbers(l1.next,l2 == null ? null : l2.next);
        }
        return l1;
    }
}
