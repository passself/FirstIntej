package com.cn.passself.generic;

/**
 * Created by shx on 2017/8/3.
 * 对于泛型类，java编译器会将泛型代码转化为普通的非泛型代码，就像上面的普通Pair类代码及其使用代码一样，
 * 将参数T擦除，替换为Object,插入必要的强制类型转换。java虚拟机实际执行的时候，它是不知道类型的。
 *
 * 泛型的好处：
 * 1.更好的安全性
 * 2.更好的可读性
 */
public class Pair <U,V>{

    U first;
    V second;

    public Pair(U first,V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst(){
        return this.first;
    }

    public V getSecond(){
        return this.second;
    }
}
