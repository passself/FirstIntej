package com.cn.passself.leetcode;

/**
 *  七进制数
 */
public class Leet504 {
    public String convertToBase7(int num) {

        StringBuilder sb = new StringBuilder();

        int flag = num >= 0? 1:-1;
        num = Math.abs(num);
        if (num == 0){
            sb.append(0);
        }
        while (num !=0){
            sb.append(num%7);
            num /=7;
        }
        if(flag <0){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String convertToBase7Src(int num) {
        return Integer.toString(num,7);
    }
}
