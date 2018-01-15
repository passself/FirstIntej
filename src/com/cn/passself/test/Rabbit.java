package com.cn.passself.test;

/**
 * Created by shihuaxian on 2018/1/15.
 * 经典兔子问题
 */
public class Rabbit {

    public static void main(String[] args) {
        System.out.println(countByMonth(20));
    }

    public static int countByMonth(int months){
        if (months == 1 || months == 2){
            return 1;
        }else {
            return countByMonth(months - 1) + countByMonth(months -2);
        }
    }
}
