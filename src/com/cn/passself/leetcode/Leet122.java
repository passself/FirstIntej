package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 买卖股票的最佳时机 II
 */
public class Leet122 {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=1;i<=prices.length-1;i++){
            if(prices[i] - prices[i-1]>0){
                ans+= prices[i] -prices[i-1];
            }
        }
        return ans;
    }


    public int maxProfitDp(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash,preHold+prices[i]);
            hold = Math.max(preHold,preCash-prices[i]);
            preHold = hold;
            preCash = cash;
        }
        return cash;
    }
}
