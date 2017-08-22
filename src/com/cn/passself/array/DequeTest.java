package com.cn.passself.array;

import java.util.*;

/**
 * Created by shx on 2017/8/22.
 */
public class DequeTest {

    public static void main(String[] args){
        Deque stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (stack.peek() != null){
            System.out.println(stack.pop());
        }

        //随机产生1000个0-3的数，统计每个数的次数
        Random rnd = new Random();
        Map countMap = new HashMap<>();
        /*for(int i=0; i<1000; i++){
            int num = rnd.nextInt(4);
            Integer count = (Integer) countMap.get(num);
            if(count == null){
                countMap.put(num,count);
            }else{
                count = count+1;
            }
            for(map.entry kv : countMap.entrySet()) {
                System.out.println(kv.getKey() + , + kv.getValue());
            }
        }*/
        for(int i=0; i<1000; i++){
            int num=rnd.nextInt(4);
            Integer count = (Integer) countMap.get(num);
            if(count==null){
                countMap.put(num, 1);
            }else{
                count = count+1;
                countMap.put(num, count);
            }
        }
        Iterator iter = countMap.entrySet().iterator();
        while (iter.hasNext()){
            //1.效率高
            Map.Entry kv = (Map.Entry)iter.next();
            System.out.println(kv.getKey() + "," +kv.getValue());
            //2.效率低
            /*Object key = iter.next();
            Object value = countMap.get(key);
            System.out.println(key + "," +value);*/
        }
    }
}
