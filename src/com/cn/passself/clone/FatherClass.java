package com.cn.passself.clone;

/**
 * Created by shx on 2017/8/11.
 */
public class FatherClass implements Cloneable{

    public String name;
    public int age;
    public ChildClass child = new ChildClass();


    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){

        }
        return null;
    }
}
