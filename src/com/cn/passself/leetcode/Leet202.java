package com.cn.passself.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 */
public class Leet202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = count(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    private int count(int n){
        int sum = 0;
        int num;
        while (n != 0){
            num = n %10;
            n = n/10;
            sum += num*num;
        }
        return sum;
    }

    /**
     * 使用递归与循环，10以外的数最终会被转换成10以内的，10以内的数除了1和7，其他都为false
     */
    public boolean isHappy3(int n){
        if (n == 1 || n ==7){
            return true;
        }else if(n < 10){
            return false;
        }
        int res = 0;
        while (n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n/10;
        }
        return isHappy3(res);
    }
}
