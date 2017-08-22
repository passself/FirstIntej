package com.cn.passself.generic;

/**
 * Created by shx on 2017/8/7.
 */
public class NumberPair<U extends Number,V extends Number> extends Pair<U,V>{

    public NumberPair(U first,V second){
        super(first,second);
    }

    /**
     * 求和
     * @return
     */
    public double sum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }
}
