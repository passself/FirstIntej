package com.cn.passself.leetcode;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 *
 */
public class Leetcode121 {

    /**
     * 时间复杂度O(n^2)
     * @param prices
     * @return
     */
    public int maxProfitNormal(int[] prices){
        if (prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        int length = prices.length;
        for (int i = 0; i < length;i++){
            for (int j = i+1; j < length; j++) {
                if (prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return  max;
    }

    /**
     * 时间复杂度O(n)
     * 范例程序，范例程序的min用来维护最小值，max用来维护最大收益。只用一重循环就完成了功能，
     * 这里的min和max在一次遍历中更新的思想值得借鉴
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        if (prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (max < prices[i] - min){
                    max = prices[i] - min;
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
