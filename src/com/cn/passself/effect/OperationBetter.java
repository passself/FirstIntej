package com.cn.passself.effect;

/**
 * Created by shihuaxian on 2018/1/24.
 * 将不同的行为与每个枚举常量关联起来
 */
public enum OperationBetter {

    PLUS{
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES{
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x,double y);

    public static void main(String[] args) {
        double result = OperationBetter.MINUS.apply(8,9);
        System.out.println(result);
    }
}
