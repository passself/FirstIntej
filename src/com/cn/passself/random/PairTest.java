package com.cn.passself.random;

/**
 * Created by shx on 2017/8/2.
 * 权重随机
 */
public class PairTest {

    public static void main(String[] args){
        Pair[] options = new Pair[]{new Pair("1元",7),
                new Pair("2元", 2),
                new Pair("10元", 1)};
        WeightRandom rnd = new WeightRandom(options);
        for (int i = 0; i < 10; i++) {
            System.out.print(rnd.nextItem()+" ");
        }
    }
}
