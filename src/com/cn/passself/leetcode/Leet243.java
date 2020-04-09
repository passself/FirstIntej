package com.cn.passself.leetcode;

/**
 * 最短单词距离
 *
 */
public class Leet243 {

    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int lastIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (lastIndex != -1 && !words[i].equals(words[lastIndex])) {
                    min = Math.min(min, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return min;
    }
}
