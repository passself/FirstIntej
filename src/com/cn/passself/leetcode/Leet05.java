package com.cn.passself.leetcode;

/**
 * 最长回文字符串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Leet05 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                right++;
                left--;
                len = len + 2;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static String longestPalindromeDp(String s) {
        if (s == null || s.length() == 0)
            return "";
        int strLen = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;

        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r) && (r-l <=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l +1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

    public static void main(String[] args) {
        String s= "babad";

        System.out.println(longestPalindrome(s));
    }
}
