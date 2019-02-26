package com.cn.passself.lru;

import java.util.*;

/**
 * 使用LinkedHashMap 来实现 两大好处
 * 1.它不是你很实现了按照访问顺序的存储，也就是说，最近读取的会放在最前面，最最不长读的会放到最后面
 * 2. LinkedHashMap 本身有一个方法用于判断是否需要移除最不常读取的数,但是原始方法默认不需要移除(这是LinkedHashMap相当于linkedlist).
 * 所以我们需要override这样的一个方法，使得当缓存里面放得数据超过规定个数后，把最不常用的移除掉
 * 可以inheritance 也可以delegation
 */
public class LruCache<K,V> {
    private static final float hashTableLoadFactor = 0.75f;

    private LinkedHashMap map;
    private int cacheSize;

    public LruCache(int cacheSize){
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int)Math.ceil(cacheSize/hashTableLoadFactor) + 1;
        map = new LinkedHashMap(hashTableCapacity,hashTableLoadFactor,true){
            //需要重写
            private static final long serialVersionUID = 1;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                //return super.removeEldestEntry(eldest);
                return size() > LruCache.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key){
        return (V) map.get(key);
    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }

    public synchronized void clear(){
        map.clear();
    }

    public synchronized int usedEntries(){
        return map.size();
    }

    public synchronized Collection<Map.Entry> getAll(){
        return new ArrayList<Map.Entry>(map.entrySet());
    }

    public static void main(String[] args) {
        LruCache c = new LruCache(3);
        c.put("1","one");
        c.put("2","two");
        c.put("3","three");
        c.put("4","four");
        if (c.get("2") == null) throw new Error();
        c.put("5","five");
        c.put("4","second four");

        //Verify cache content
        if (c.usedEntries() != 3) throw new Error();
        if (!c.get("4").equals("second four")) throw new Error();
        if (!c.get("5").equals("five"))        throw new Error();
        if (!c.get("2").equals("two"))         throw new Error();
        // List cache content.

        List<Map.Entry> list = (List<Map.Entry>) c.getAll();
        for (Map.Entry e:list){
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}
