package com.cn.passself.clone;

/**
 * Created by shx on 2017/8/11.
 */
public class ChildClass implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){

        }
        return null;
    }
}
