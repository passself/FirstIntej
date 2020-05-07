package com.cn.passself.leetcode;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Leet28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {

        int hlen = haystack.length(), nLen = needle.length();
        for (int i = 0; i <= hlen - nLen; i++) {
            int j = 0;
            for (; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }
}
