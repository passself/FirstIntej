package com.cn.passself.singleton;

/**
 * Created by shx on 17/2/15.
 * 一个类的静态属性只会在类加载的时候初始化
 */
public class InnerClassSingleton {

    public static InnerClassSingleton getInstance(){
        return Singleton.innerClassSingleton;
    }

    private static class Singleton{
        protected static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }
}
