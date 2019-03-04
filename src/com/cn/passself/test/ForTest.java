package com.cn.passself.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 参考https://mp.weixin.qq.com/s/e9ITxUmsMFhfjeHhOgTtfA
 * 数组修改数据正确姿势
 */
public class ForTest {

    public static void main(String[] args) {

        List<String> usernames = new ArrayList<String>(){
            {
                add("Hollis");
                add("hollis");
                add("hollisChuang");
                add("H");
            }
        };

        /*for (int i = 0; i < usernames.size() - 1; i++) {
            if (usernames.get(i).equals("Hollis")){
                usernames.remove(usernames.get(i));
            }
        }
        System.out.println(usernames);*/

        /**
         * 增强for循环进行元素删除，add/remove元素的时候会抛出java.util.ConcurrentModificationException的原因
         * fail-fast 机制
         * fail-fast 即快速失败，它是java集合的一种错误检查机制。当多个线程集合(非fail-safe的集合类)进行结构上的改变的操作时,
         * 有可能产生fail-fast 机制，这个时候就会抛出ConcurrentModificationException
         * 当方法检测到对象的并发修改，但不允许这种修改时就抛出该异常
         * 需要注意的是，即使不是多线程，如果是单线程违反了规则
         */
        //方法2
        /*for (String str: usernames) {
            if (str.equals("Hollis")){
                usernames.remove(str);
                break;//改进后不再报错
            }
        }*/

        //方法3
        /*Iterator iterator = usernames.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Hollis")){
                iterator.remove();
            }
        }*/

        //方法4 直接使用fail-fast的集合类，适用于多线程操作
        ConcurrentLinkedDeque<String> newUserNames = new ConcurrentLinkedDeque<String>(){
            {
                add("Hollis");
                add("hollis");
                add("hollisChuang");
                add("H");
            }
        };
        for (String userName : newUserNames) {
            if (userName.equals("Hollis")) {
                newUserNames.remove();
            }
        }
        System.out.println(newUserNames);
        //迭代器遍历的是开始遍历那一刻拿到的集合拷贝，在遍历期间原集合发生的修改迭代器是不知道的
    }
}
