package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计重复个数
 * https://leetcode-cn.com/problems/count-the-repetitions/
 */
public class Leet466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0) return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int couts1=0;//经历多少s1
        int couts2=0;//经历多少s2
        int p=0;//当前在s2的位置
        Map<Integer,int[]> mp = new HashMap<>();//记录每一次s1扫描结束后当前的状态，寻找循环
        while(couts1<n1){
            for(int i=0;i<l1;i++){
                if(c1[i]==c2[p]){//往前
                    p++;
                    if(p==l2){//s2扫描结束从头开始循环
                        p=0;
                        couts2++;
                    }
                }
            }
            couts1++;
            if(!mp.containsKey(p)){
                mp.put(p,new int[]{couts1,couts2});//记录当前状态

            }
            else{//出现了循环 这次结束后p的位置和以前某一次一样，就是循环
                int[] last =mp.get(p);
                int circle1= couts1-last[0];
                int circle2= couts2-last[1];
                couts2 += circle2*((n1-couts1)/circle1);
                couts1 = couts1+((n1-couts1)/circle1)*circle1;//更新新他们
            }
        }
        return couts2/n2;
    }

    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 特判
        if (len1 == 0 || len2 == 0 || n1 == 0 || n2 == 0) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // 记录下一个要匹配的s2中字符的索引
        int index = 0;
        // 记录匹配完的s2个数
        int count = 0;
        // 记录在遍历每个s1时匹配出的s2的个数，可能是包含了前面一个s1循环节的部分
        int[] countRecorder = new int[n1];
        // 记录在每个s1中想要匹配的s2中字符的索引
        int[] indexRecorder = new int[n1];

        for (int i = 0; i < n1; ++i) {
            // 遍历s1
            for (int j = 0; j < len1; ++j) {
                // 匹配s2字符，匹配成功，s2索引+1
                if (chars1[j] == chars2[index]) {
                    ++index;
                }
                // 匹配完一个s2，计数器+1，重置s2索引
                if (index == chars2.length) {
                    index = 0;
                    ++count;
                }
            }
            // 记录遍历完i个s1后s2出现的次数
            countRecorder[i] = count;
            // 记录遍历完第i个s1后s2下一个要被匹配到的字符下标
            indexRecorder[i] = index;
            // 剪枝
            // 查看该索引在之前是否已出现，出现即表示已经出现循环节，可以直接进行计算
            // 上一次出现该索引是在第j个s1中（同时可以说明第一个循环节的出现是从第j+1个s1开始的）
            for (int j = 0; j < i && indexRecorder[j] == index; ++j) {
                // preCount: 记录循环节出现之前的s2出现的个数
                int preCount = countRecorder[j];
                // patternCount: 记录所有循环节构成的字符串中出现s2的个数
                //      (n1 - 1 - j) / (i - j): 循环节个数
                //      countRecorder[i] - countRecorder[j]: 一个循环节中包含的s2个数
                int patternCount = ((n1 - 1 - j) / (i - j)) * (countRecorder[i] - countRecorder[j]);
                // remainCount: 记录剩余未构成完整循环节的部分出现的s2的个数
                //      通过取模从已有循环节记录中查找，并减去循环节之前出现的次数
                int remainCount = countRecorder[j + (n1 - 1 - j) % (i - j)] - countRecorder[j];
                // 三者相加，即为出现的s2的总次数
                return (preCount + patternCount + remainCount) / n2;
            }
        }
        // 没有循环节的出现，相当于直接使用暴力法
        return countRecorder[n1 - 1] / n2;
    }
}
