package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * 字符串轮转
 */
public class Review0109 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        s1 += s1;
        return s1.contains(s2);
    }
}
