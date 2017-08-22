package com.cn.passself.random;

/**
 * Created by shx on 2017/8/2.
 */
public class Pair {

    Object item;
    int weight;

    public Pair(Object item, int weight){
        this.item = item;
        this.weight = weight;
    }

    public Object getItem() {
        return item;
    }

    public int getWeight() {
        return weight;
    }
}
