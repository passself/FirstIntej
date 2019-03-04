package com.cn.passself.algorithm;

import java.util.*;

/**
 * 求众数
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/261/before-you-start/1107/
 */
public class ModeCount {

    public static void main(String[] args) {
        int array[] = new int[]{2,2,1,1,1,2,2};
        System.out.println(findMode(array));
    }

    public static int findMode(int array[]){
        if (array == null || array.length == 0){
            return 0;
        }
        int length = array.length;
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int item:array){
            if (resultMap.get(item) == null){
                resultMap.put(item,1);
            }else{
                resultMap.put(item,resultMap.get(item)+1);
            }
        }
        List<Map.Entry<Integer, Integer>> keyList = new LinkedList<>(resultMap.entrySet());
        Collections.sort(keyList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map.Entry first = ((LinkedList<Map.Entry<Integer, Integer>>) keyList).getFirst();
        int count = (int)(first.getValue());
        int key = (int)(first.getKey());
        if (count >length/2){
            return key;
        }else{
            return 0;
        }
    }
}
