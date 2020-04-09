package com.cn.passself.leetcode;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Leet714 {

    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        for (int i = 1; i <= prices.length-1; i++) {
            if (prices[i]-prices[i-1]-fee>0){
                ans += prices[i]-prices[i-1]-fee;
            }
        }
        return ans;
    }

    /**
     * 我们维护两个变量
     * cash 和hold，前者表示当我们不持有股票时的最大利润，后者表示当我们持有股票时的最大利润。
     *
     * 在第i 天时，我们需要根据第i−1天的状态来更新cash 和hold 的值。对于cash，我们可以保持不变，
     * 或者将手上的股票卖出，状态转移方程为
     * cash = max(cash,hold+prices[i]-fee)
     * 对于hold，我们可以保持不变，或者买入这一天的股票，状态转移方程
     * hold = max(hold,cash-prices[i])
     * 在计算这两个状态转移方程时，我们可以不使用临时变量来存储第i-1天cash和hold的值，而是可以先计算cash再计算hold，
     * 原因是在同一天卖出或者买入(亏了一笔手续费)一定不会比不进行任何操作好
     * @param prices
     * @param fee
     * @return
     * 时间复杂度是O(n)
     * O(n)，其中n是prices 数组的长度
     *
     * 空间复杂度:O(1)
     */
    public int maxProfitD(int[] prices,int fee){
        int cash = 0, hold = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash,hold+prices[i]-fee);
            hold = Math.max(hold,cash-prices[i]);
        }
        return cash;
    }
}
