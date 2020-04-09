package com.cn.passself.algorithm;

/**
 * 八种基本的排序算法
 * @link com.cn.pasself.leetcode.Leet912
 *
 */
public class AllSort {

    public static void insertSort(int[] nums){
        int length = nums.length;

        int insertNum;//要插入的数

        for (int i = 0; i < length; i++) {
            insertNum = nums[i];
            int j = i-1;//已经排好序，元素个数
            while (j>=0 && nums[i]>insertNum){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = insertNum;//将需要插入的数放在要插入的位置
        }
    }

}
