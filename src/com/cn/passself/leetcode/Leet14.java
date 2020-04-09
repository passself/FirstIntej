package com.cn.passself.leetcode;

public class Leet14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("") || res.equals("")) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < str.length() && str.charAt(start) == res.charAt(start)) {
                start++;
            }
            res = res.substring(0, start);
        }
        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";

        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (min_length > strs[i].length())
                min_length = strs[i].length();
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < min_length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i))
                    return res.toString();
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
