package com.cn.passself.random;

import java.util.Random;

/**
 * Created by shx on 2017/8/2.
 * 抢红包算法
 */
public class RandomRedPacket {
    private int leftMoney;//剩余金额
    private int leftNum;//剩余个数
    private Random rnd;

    public RandomRedPacket(int total,int num){
        this.leftMoney = total;
        this.leftNum = num;
        this.rnd = new Random();
    }

    public synchronized int nextMoney(){
        if (this.leftNum <= 0){
            throw new IllegalStateException("抢光了");
        }

        if (this.leftNum <=1){
            return this.leftMoney;
        }

        double max = this.leftMoney/this.leftNum *2d;//随机最大值为平均值的两倍，然后取一个随机值
        int money = (int)(rnd.nextDouble()*max);
        money = Math.max(1,money);//最小不能小于1
        this.leftMoney -=money;
        this.leftNum --;

        return money;
    }

    public static void main(String[] args){
        int sum = 20;
        RandomRedPacket randomRedPacket = new RandomRedPacket(1000,sum);
        for(int i=0; i<sum; i++){
            System.out.print(randomRedPacket.nextMoney()+" ");
        }
    }
}
