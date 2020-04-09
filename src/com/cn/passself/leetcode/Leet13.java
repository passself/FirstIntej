package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Leet13 {

    public int romanToInt(String s) {
        if (s == null || s.length() ==0){
            return 0;
        }
        int ans = toNum(s.charAt(0));

        for (int i = 1; i < s.length(); i++){
            ans += toNum(s.charAt(i));
            if (toNum(s.charAt(i))>toNum(s.charAt(i-1))){
                ans = ans - 2*toNum(s.charAt(i-1));
            }
        }
        return ans;
    }

    public int toNum(Character ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s= "IV";
        int result = new Leet13().romanToInt(s);
        System.out.println(result);
    }
}
