package com.cn.passself.leetcode;

/**
 * Created by shx on 2017/8/28.
 * 移位运算
 */
public class ShiftOperation {
    public static void main(String[] args){
        int number = 10;
        //原始二进制
        prinfBinaryInfo(number);

        number = number << 1;
        //左移一位
        prinfBinaryInfo(number);

        //右移一位
        number = number >> 1;
        prinfBinaryInfo(number);

        //无符号右移,空位0补全
        number = number >>>1;
        prinfBinaryInfo(number);

        int res = hammingDistance(10,19);
        System.out.println("hammingDistance is:"+res);
    }

    public static void prinfBinaryInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }

    public static int hammingDistance(int x,int y){
        int res = 0, exc = x ^ y;
        for (int i = 0; i < 32; ++i) {
            res += (exc >> i) & 1;
        }
        return res;
    }

    public static int hammingDistanceOneLine(int x,int y){
        return Integer.bitCount(x ^ y);
    }

    public static boolean judgeCircle(String moves){
        int x = 0,y=0;
        for (char ch:moves.toCharArray()){
            if (ch == 'U') y++;
            if (ch == 'D') y--;
            if (ch == 'L') x--;
            if (ch == 'R') x++;
        }
        return x == 0 & y == 0;
    }

}
