package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 字符串转换整数
 */
public class Leet08 {

    public int myAtoi(String str){
        if (str == null || str.length() == 0 || str.trim().length() ==0){
            return 0;
        }

        String str1 = str.trim();
        int flag = 1;//默认正数
        int index  = 0; //默认无符号从0开始
        if (str1.charAt(0) == '-'){
            flag = -1;
            index = 1;
        }else if (str1.charAt(0) == '+'){
            index = 1;
        }
        int ans = 0;
        while(index< str1.length() && str1.charAt(index)>='0' && str1.charAt(index) <='9'){
            int n = (str1.charAt(index) - '0') * flag;
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE /10 && n>7)){
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE /10 || (ans == Integer.MIN_VALUE /10 && n<-8)){
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + n;
            index++;
        }
        return ans;
    }
}
