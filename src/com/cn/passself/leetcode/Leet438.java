package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet438 {

    /**
     * 未理解
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.equals("") || s.length() < p.length()) return list;
        int[] freq = new int[256];
        for(int j=0;j<p.length();j++){
            freq[p.charAt(j)]++;
        }
        int count = p.length();
        int left = 0,right = 0;
        while(right<s.length()){
            if(freq[s.charAt(right++)] -- >=1) count--;
            if(count ==0) list.add(left);
            if(right -left == p.length() && freq[s.charAt(left++)]++ >=0) count++;
        }
        return list;
    }

    
}
