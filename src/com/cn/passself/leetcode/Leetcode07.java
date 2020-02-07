package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Leetcode07 {

    public int reverse(int x){
        long y = 0;
        while (x != 0){
            y = y *10 + x%10;
            x /= 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            return 0;
        }
        return (int)y;
    }

    /**
     * 最大的值与最小的值为：[−2^31, 2^31 − 1]， 即：[-2147483648, 2147483647]
     * 如果 y = y * 10+ y%10  溢出，则y>=2147483648
     * 当 y = 214748364 时, 输入值只能为:1463847412，此时不溢出
     * 即：y > 214748364 || y < -214748364 必定溢出
     * @param x
     * @return
     */
    public static int reverseNew(int x){
        int y = 0;
        while (x != 0){
            if (y > 214748364 || y < -214748364){
                return 0;
            }
            y = y* 10 + x%10;
            x /=10;
        }
        return y;
    }

    public static void main(String[] args) {
        int a  = 1098762021;
        int result = reverseNew(a);
        System.out.println(result);
    }
}
