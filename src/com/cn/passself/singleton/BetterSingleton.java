package com.cn.passself.singleton;

/**
 * Created by shx on 17/2/15.
 * 比较普通和常见的写法,规则如下：
 * 1.Singleton 最多一个实例，在不考虑反射强行突破访问限制的情况下
 * 2.保证了并发访问的情况下，不会由于并发而产生多个实例
 * 3.保证了并发访问的情况下，不会由于初始化动作未完全完成而造成使用了尚未正确初始化实例
 */
public class BetterSingleton {

    private BetterSingleton(){}

    public static BetterSingleton getInstance(){
        return InnerClass.betterSingleton;
    }

    private static class InnerClass{
        static BetterSingleton betterSingleton = new BetterSingleton();
    }
}
