package com.cn.passself.test;

/**
 * Created by shihuaxian on 2018/4/20.
 */
public enum VersionType {
    NORMAL("com.huaxia.finance"),
    PROFESSION("com.huaxia.profession");

    String str;
    VersionType(String s){
        str = s;
    }

    public String getTypeByName(){
        return str;
    }
}
