package com.cn.passself.leetcode;

public class Leet470 {

    public int rand7(){
        return (int) Math.random() * 7;
    }

    public int rand10() {
        int a = rand7();
        int b = rand7();

        if((a==6) && b>=6 || a == 7){
            return rand10();
        }else{
            return ((a-1)*7 + b-1)%10 -1;
        }
    }
}
