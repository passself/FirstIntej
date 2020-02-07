package com.cn.passself.leetcode;

import java.util.Arrays;

public class Leetcode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return digits;
        }

        boolean isPlus = false;

        for (int i = digits.length -1 ; i >= 0; i--) {
            isPlus = false;
            if(digits[i] == 9){
                digits[i] = 0;
                isPlus = true;
                continue;
            }else{
                digits[i] = digits[i] + 1;
                break;
            }
        }

        if (isPlus){
            int nums[] = new int[digits.length+1];
            nums[0] = 1;
            return nums;
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits){
        for (int i = digits.length -1; i >= 0; i--){
            digits[i] ++;
            digits[i] = digits[i]%10;
            if (digits[i] !=0) return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int digits[] = {1,9,9};
        System.out.println(Arrays.toString(plusOne2(digits)));
    }
}
