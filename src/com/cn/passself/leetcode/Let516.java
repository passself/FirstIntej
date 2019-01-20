package com.cn.passself.leetcode;

import java.util.Vector;

/**
 * Created by shx on 2019/1/20.
 */
public class Let516 {
    public static String longestPalindrome(String s) {
        if (s.isEmpty())

        {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (
                int i = n - 2;
                i >= 0; i--)

        {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }


    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }



    public static void main(String[] args) {
        System.out.printf("" + longestPalindrome("opopoppdsadaqaaadddaaaqad").length());
        System.out.println("" + longestPalindrome("bbbab").length());
        System.out.println("" + longestPalindromeSubseq("bbbab"));
        //System.out.println("" + Manacher("bbbab"));
    }
}
