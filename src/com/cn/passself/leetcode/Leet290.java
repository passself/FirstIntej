package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/comments/
 * 单词规律
 */
public class Leet290 {

    public static boolean wordPattern(String pattern,String str){
        if (pattern == null || str == null) return false;
        String[] string = str.split(" ");
        if (pattern.length() != string.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++){
            char tmp = pattern.charAt(i);
            if (map.containsKey(tmp)){
                if (!map.get(tmp).equals(string[i])) return false;
            }else {
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(string[i])) return false;
                else map.put(tmp,string[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
}
