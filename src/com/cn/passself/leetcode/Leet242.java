package com.cn.passself.leetcode;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 */
public class Leet242 {

    public boolean isAnagramSort(String s, String t) {
        if (s.length() !=t.length()){
            return false;
        }
        char[] str1 =  s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}
