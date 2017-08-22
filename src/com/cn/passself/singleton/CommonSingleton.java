package com.cn.passself.singleton;

/**
 * Created by shx on 17/2/15.
 */
public class CommonSingleton {
    private static CommonSingleton instance;

    private CommonSingleton(){}

    public static CommonSingleton getInstance(){
        if (instance == null){
            instance = new CommonSingleton();
        }
        return instance;
    }
}
