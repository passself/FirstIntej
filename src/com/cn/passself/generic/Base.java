package com.cn.passself.generic;


/**
 * Created by shx on 2017/8/8.
 */
public class Base implements Comparable<Base>{

    private int sortOrder;

    public Base(int sortOrder){
        this.sortOrder = sortOrder;
    }

    @Override
    public int compareTo(Base o) {
        if (sortOrder < o.sortOrder){
            return -1;
        }
        if (sortOrder > o.sortOrder){
            return 1;
        }else {
            return 0;
        }
    }

    public int getSort(){
        return sortOrder;
    }
}
