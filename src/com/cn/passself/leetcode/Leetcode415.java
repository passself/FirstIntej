package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/add-strings/solution/
 */
public class Leetcode415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carray = 0;
        StringBuilder result = new StringBuilder();
        while(i>=0 || j >= 0){

            // 判断是否越界 越界就是0 不越界的话就取那个数
            int a = i>=0 ? num1.charAt(i) - '0' :0;
            int b = j >=0 ? num2.charAt(j) - '0': 0;
            int temp = a+b+carray;
            carray = temp/10;
            result.append(temp%10);
            i--;
            j--;
        }
        if (carray ==1) result.append(1);
        return result.toString();
    }
}
