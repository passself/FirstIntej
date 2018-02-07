package com.cn.passself.effect;

/**
 * Created by shihuaxian on 2018/1/24.
 * 不加throw exception 无法编译过，无法扩展
 */
public enum OperationFirst {
    PLUS,MINUS,TIMES,DIVIDE;

    double apply(double x,double y){
        switch (this){
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("unknown op:"+this);
    }

    public static void main(String[] args) {
        double result = OperationFirst.PLUS.apply(3,2);
        System.out.println(result);
    }
}
