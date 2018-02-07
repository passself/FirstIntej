package com.cn.passself.effect;

/**
 * Created by shihuaxian on 2018/1/24.
 * 添加操作方式
 */
public enum OperationBest {

    PLUS("+"){
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    public String toString(){
        return symbol;
    }

    OperationBest(String symbol){
        this.symbol = symbol;
    }

    abstract double apply(double x,double y);

    public static void main(String[] args) {
        double x = 9;
        double y = 3;
        for (OperationBest op:OperationBest.values()){
            System.out.println(op.apply(9,3));
            System.out.printf("%f %s %f=%f%n",x,op,y,op.apply(x,y));
        }
    }
}
