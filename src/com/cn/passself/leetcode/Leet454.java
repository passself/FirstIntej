package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加II
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class Leet454 {

    /**
     * 采用分为两组，HashMap存一组，另一组和HashMap进行比对。
     * 以存AB两数组之和为例,首先求出A和B任意两数之和sumAB， 以sumAB为key，sumAB出现的次数为value，
     * 存入hashmap
     * 然后计算C和D中任意两数之和的相反数sumCD，在hashmap中查找是否存在key为sumCD
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0;
        for (int i = 0; i < A.length; i++){
            for (int j =0;j<B.length; j++){
                int sumAB = A[i]+B[j];
                if (map.containsKey(sumAB)) map.put(sumAB,map.get(sumAB)+1);
                else map.put(sumAB,1);
            }
        }

        for(int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i]+D[j]);
                if (map.containsKey(sumCD)) res += map.get(sumCD);
            }
        }

        return res;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int a:A) {
            for(int b:B) {
                map.merge(a+b, 1, (v1,v2)->v1+1);
            }
        }
        int res=0;
        for(int c:C) {
            for(int d:D) {
                res+=map.getOrDefault(0-c-d, 0);
            }
        }
        return res;
    }
}
