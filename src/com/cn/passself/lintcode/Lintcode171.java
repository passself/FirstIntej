package com.cn.passself.lintcode;

import java.util.Set;

/**
 * https://www.lintcode.com/problem/word-break/description
 * 单词拆分
 */
public class Lintcode171 {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 && dict.size() == 0) {
            return true;
        }
        if (s.length() == 0 || dict.size() == 0) {
            return false;
        }

        /*int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0]= true;*/
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {

            if (!dp[i]) continue;

            for (String item : dict) {
                int iLength = item.length();
                int end = i + iLength;
                if (end > len) {
                    continue;
                }
                if (dp[end]) continue;

                if (s.substring(i,end).equals(item)){
                    dp[end] = true;
                }
            }
        }
        return dp[len];
    }
}
