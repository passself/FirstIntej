package com.cn.passself.leetcode;

import java.util.LinkedList;

/**
 * 回文数字
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Leet09 {



    public static void main(String[] args) {
        int num = 121;
        //System.out.println(isPalindrome(num));
        System.out.println(isPalindromeLink(num));
    }

    /**
     * 整除实现
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x<0 || (x!= 0  && x%10 ==0)){
            return false;
        }

        int reverNum = 0;
        while (x > reverNum){
            reverNum = reverNum * 10 + x % 10;
            x = x /10;
        }
        return x == reverNum || x == reverNum/10;
    }

    /**
     * 利用链表的特性
     * @param x
     * @return
     */
    public static boolean isPalindromeLink(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        int next = x;

        while (next != 0){
            int temp = next % 10;
            next = next/10;
            linkedList.push(temp);
        }

        for (int i = 0; i < linkedList.size() / 2;) {
            if (!linkedList.pop().equals(linkedList.pollLast())){
                return false;
            }
        }
        return true;
    }
}
