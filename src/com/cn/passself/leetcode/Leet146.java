package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU缓存机制
 */
public class Leet146 {

    LinkedHashMap<Integer,Integer> map;
    public Leet146(int capacity) {
        map=new LinkedHashMap<Integer,Integer>(16,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }

    public class LRUCacheBeta<K, V> {
        int capacity;
        Map<K, V> map;
        LinkedList<K> list;

        public LRUCacheBeta(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        /**
         * 添加元素
         * 1.元素存在，放到队尾
         * 2.不存在，判断链表是否满。
         * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
         * 如果不满，放入队尾元素，更新哈希表
         */
        public void put(K key, V value) {
            V v = map.get(key);
            if (v != null) {
                list.remove(key);
                list.addLast(key);
                map.put(key, value);
                return;
            }

            //队列未满，添加到尾部
            if (list.size() < capacity) {
                list.addLast(key);
                map.put(key, value);
            } else {
                //队列已满，移除队首
                K firstKey = list.removeFirst();
                map.remove(firstKey);
                list.addLast(key);
                map.put(key, value);
            }
        }

        /**
         * 访问元素
         * 元素存在，放到队尾
         */
        public V get(K key) {
            V v = map.get(key);
            if (v != null) {
                list.remove(key);
                list.addLast(key);
                return v;
            }
            return null;
        }
    }
}


