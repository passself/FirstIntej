package com.cn.passself.leetcode;

/**
 * 双指针法
 * @todo 动态规划
 */
public class Leet42 {

    /**
     * 每个柱子接到的雨水等于这个柱子左右两边最大值中较小者减去柱子本身的高度
     * @param height
     * @return
     */
    public int trap(int[] height){

        if (height == null || height.length ==0){
            return 0;
        }
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        /**
         * 计算出每一列中左边最高， 右边最高的高度
         * 每一列中包含水滴的个数 = 当前节点两边最大高度的较小值 - 当前节点高度
         */
        left[0] = height[0];
        right[len -1]= height[len - 1];
        for (int i =1 ; i < len; i++) {
            left[i] = Math.max(height[i],left[i-1]);
            right[len - i -1] = Math.max(right[len-1],height[len -i-1]);
        }
        int cnt = 0;
        for (int i =0 ; i < len;i++){
            cnt += Math.min(left[i],right[i]-height[i]);
        }
        return cnt;
    }


    /**
     * 对上面方法进行优化，只扫描一遍，利用双指针，边扫描边计算
     * @param height
     * @return
     */
    public int trapN(int[] height){
        if (height == null || height.length ==0){
            return 0;
        }
        int len = height.length;
        int leftMax = 0, rightMax= 0;
        int left = 0, right =len -1;
        int result = 0;

        while(left < right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);
            if(leftMax < rightMax){
                result += leftMax - height[left++];
            }else{
                result += rightMax - height[right--];
            }
        }
        return result;
    }
}
