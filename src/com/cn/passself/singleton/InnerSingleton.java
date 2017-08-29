package com.cn.passself.singleton;

/**
 * Created by shx on 2017/8/29.
 * 内部类单例
 */
public class InnerSingleton {

    private static class Inner{
        private static InnerSingleton instance = new InnerSingleton();

        static InnerSingleton get(){
            return instance;
        }
    }

    public static InnerSingleton getInstance(){
        return Inner.get();
    }

    private InnerSingleton(){}
}
