package com.cn.passself.normal;

/**
 * 是否是奇数
 */
public class NiceUtils {


    public static boolean isOdd1(int num){
        if (num%2 ==1 || num%2== -1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isOdd2(int num){
        return num%2 == 1|| num%2== -1;
    }

    public static boolean isOdd3(int num){
        return num % 2 != 0;
    }

    public static boolean isOdd4(int num){
        return num % 2 != 0;
    }

    public static boolean isOdd5(int num){
        return num >>1 << 1 != num;
    }

    public static boolean isOdd6(int num){
        return (num & 1) == 1;
    }


}
