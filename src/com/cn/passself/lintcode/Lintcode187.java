package com.cn.passself.lintcode;

/**
 * https://www.lintcode.com/problem/gas-station/description
 * 贪心
 */
public class Lintcode187 {

    public int canCompleteCircuit(int[] gas,int[] cost){
        if (gas == null || gas.length ==0)
            return -1;
        if (cost == null || cost.length ==0)
            return -1;

        int index = 0;
        int total = 0;
        int current = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasOff = gas[i] - cost[i];
            total += gasOff;
            current += gasOff;
            if (current < 0){
                index = i+1;
                current = 0;
            }
        }
        if (total <0)
            return -1;
        else
            return index;
    }
}
