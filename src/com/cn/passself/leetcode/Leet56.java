package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 合并区间
 */
public class Leet56 {

    /**
     * 1.首先根据二维数组中每个一维数组的[0]进行升序排序，即根据start进行排序；
     * 2.合并条件是前一个的结束 大于等于 后一个的开始
     * 3.然后建立linkedList作为中间处理对象，当集合为空或者不满足条件，加入集合的末尾；
     * 4.集合不为空且满足合并条件时，取集合中最后一个元素让它的end为原值和合并区间end中的最大值，解决1,5;2,4这样的区间问题。
     * 5.集合处理完成，对其循环遍历取首元素，放入res结果数组中
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.parallelSort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> list  = new LinkedList<> ();
        for(int i=0;i<intervals.length; i++){
            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]){
                list.add(intervals[i]);
            }else{
                list.getLast()[1] = Math.max(list.getLast()[1],intervals[i][1]);
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        while(!list.isEmpty()){//遍历集合
            res[index++] = list.removeFirst();
        }

        return res;
    }

    /**
     * 参考
     * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
     * 合并 2 个区间
     * 先根据区间的起始位置排序，再进行
     *
     * n−1 次 两两合并。
     */
    public static int[][] merge2(int[][] intervals){
        //先按照区间起始位置排序
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        //遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval:intervals) {
            //如果结果数组是空的，或者当前区间的起始位置>结果数组中最后区间的终止位置
            //则不合并，直接将当前区间加入结果数组
            if (idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else{
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge2(intervals));
    }
}
