package com.cn.passself.singleton;

/**
 * Created by shx on 17/2/15.
 */
public class BetterSyncSingleton {
    private static BetterSyncSingleton instance;

    private BetterSyncSingleton(){}

    public static BetterSyncSingleton getInstance(){
        if (instance == null){
            synchronized (BetterSyncSingleton.class){
                if (instance == null){
                    instance = new BetterSyncSingleton();
                }
            }
        }
        return instance;
    }
}
