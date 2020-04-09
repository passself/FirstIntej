package com.cn.passself.leetcode;

/**
 *
 */
public class Leet43 {

    public String multiply(String num1,String num2){
        if (num1.length() == 0 || num2.length() == 0){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for (int i = len1-1; i >=0; i--) {
            for (int j =len2 - 1; j >= 0; j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int indexLow = i+j+1;
                int indexHight = i+j;
                mul += result[indexLow];
                result[indexLow] = mul%10;
                result[indexHight] += mul /10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int res:result){
            if(!(sb.length()==0&& res ==0))sb.append(res);
        }
        return sb.length() ==0?"0":sb.toString();
    }
}
