package com.cn.passself.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shx on 2019/5/4.
 * https://www.lintcode.com/problem/anagrams/description
 */
public class Lintcode171 {

    public List<String> anagrams(String[] strs){
        List<String> result = new ArrayList<>();
        if ( strs == null || strs.length<=1){
            return result;
        }
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!hashMap.containsKey(s)){
                List<String> stringList = new ArrayList<>();
                hashMap.put(s,stringList);
            }
            hashMap.get(s).add(strs[i]);
        }
        for (String s:hashMap.keySet()) {
            if (hashMap.get(s).size() > 1){
                for (String ss:hashMap.get(s)){
                    result.add(ss);
                }
            }
        }
        return result;
    }
}
