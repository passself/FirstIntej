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

    /*****************官方解答**************/
    public boolean isHappyG(int n){
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n){
        int res = 0;
        int num;
        while(n!=0){
            num = n%10;
            n = n/10;
            res = num * num;
        }
        return res;
    }

    /**
     * 快慢指针
     * 1，如果n是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字1
     * 2. 如果n不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇
     */

    public boolean isHappyKM(int n){
        int slowRunner = 0;
        int fastRunnaer = getNext(n);
        while (fastRunnaer != 1 && slowRunner != fastRunnaer){
            slowRunner = getNext(n);
            fastRunnaer = getNext(getNext(n));
        }
        return fastRunnaer == 1;
    }

}
