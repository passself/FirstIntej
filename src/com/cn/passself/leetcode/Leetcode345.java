package com.cn.passself.leetcode;

public class Leetcode345 {

    private boolean isYuan(char c){
        if ("aeiouAEIOU".indexOf(c) != -1) return true;
        return false;
    }
    public String reverseVowels(String s) {

        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();

        while (left < right){
            while (left < right && !isYuan(c[left])) left ++;
            while (left < right && !isYuan(c[right])) right--;
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left ++;
            right --;
        }

        return new String(c);
    }
}
