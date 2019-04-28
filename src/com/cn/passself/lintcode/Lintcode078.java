package com.cn.passself.lintcode;

public class Lintcode078 {

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }
        String prefix = strs[0];

        for (String string:strs){
            while(!string.startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }
}
