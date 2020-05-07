package com.cn.passself.leetcode;
import	java.util.Collections;
import	java.util.ArrayList;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 根据字符出现频率排序
 */
public class Leet451 {

    public static String frequencySort(String s){
        if (s == null || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new TreeMap<Character,Integer>();

        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if (map.containsKey(ch)){
                Integer count = map.get(ch);
                count++;
                map.put(ch,count);
            }else{
                map.put(ch,1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry <Character, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character, Integer>> () {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            for(int i = 0;i<entry.getValue(); ++i){
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String tmp = "tree";
        System.out.println(frequencySort(tmp));
    }
}
