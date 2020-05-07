package com.cn.passself.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * 最低票价
 */
public class Leet983 {

    int[] days,costs;
    Integer[] memo;
    Set<Integer> dayset;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[366];//一年365天
        dayset = new HashSet();

        for (int d : days) {
            dayset.add(d);
        }

        return dp(1);
    }

    public int dp(int i){
        if (i>365){
            return 0;
        }
        if (memo[i] != null){
            return memo[i];
        }
        if (dayset.contains(i)){
            memo[i] = Math.min(Math.min(dp(i+1)+costs[0],dp(i+7)+costs[1]), dp(i+15)+costs[2]);
        }
        else {
            memo[i] = dp(i+1);
        }

        return memo[i];
    }

    public int dp2(int i){
        if (i >= days.length){
            return 0;
        }

        if (memo[i] != null){
            return memo[i];
        }
        memo[i] = Integer.MAX_VALUE;
        int  j = i;
        for(int k = 0;k<3;++k){
            while (j<days.length && days[j] < days[i] + durations[k]){
                j++;
            }
            memo[i] = Math.min(memo[i] , dp2(j) + costs[k]);
        }
        return memo[i];
    }
}
