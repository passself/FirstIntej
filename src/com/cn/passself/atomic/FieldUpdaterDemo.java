package com.cn.passself.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by shihuaxian on 2018/2/7.
 *
 * CAS compareAndSet 是java并发包的基础，基于它可以实现高效的，乐观，非阻塞式数据结构和算法，它也是并发包中锁，同步工具和各种容器的基础。
 */
public class FieldUpdaterDemo {

    static class DemoObject{
        private volatile int num;
        private volatile Object ref;

        private static final AtomicIntegerFieldUpdater<DemoObject> numUpdater
                = AtomicIntegerFieldUpdater.newUpdater(DemoObject.class,"num");

        private static final AtomicReferenceFieldUpdater<DemoObject,Object> refUpdater
                = AtomicReferenceFieldUpdater.newUpdater(DemoObject.class,Object.class,"ref");

        public boolean compareAndSetNum(int expect,int update){
            return numUpdater.compareAndSet(this,expect,update);
        }

        public int getNum(){
            return num;
        }

        public Object compareAndSetRef(Object expect,Object update){
            return refUpdater.compareAndSet(this,expect,update);
        }

        public  Object getRef(){
            return ref;
        }
    }

    public static void main(String[] args) {
        DemoObject obj = new DemoObject();
        System.out.println(obj.getNum());
        System.out.println(obj.getRef());
        obj.compareAndSetNum(0,100);
        obj.compareAndSetRef(null,new String("Hello"));
        System.out.println(obj.getNum());
        System.out.println(obj.getRef());
    }
}
