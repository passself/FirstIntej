package com.cn.passself.map;

import java.util.Collections;
import java.util.Map;

/**
 * Created by shx on 2017/12/23.
 * 把非同步的map转换称同步
 */
public class EnhancedMap<K,V> {

    Map<K,V> kvMap;

    public EnhancedMap(Map<K,V> map){
        this.kvMap = Collections.synchronizedMap(map);
    }

    public V putIfAbsent(K key,V value){
        V old = kvMap.get(key);
        if (old != null){
            return old;
        }
        kvMap.put(key,value);
        return null;
    }

    //错误的同步方式，使用的同步对象是EnhancedMap而需要同步的是kvMap
    public synchronized V putIfAbsentError(K key,V value){
        V old = kvMap.get(key);
        if (old != null){
            return old;
        }
        kvMap.put(key,value);
        return null;
    }

    //正确的同步方式
    public V putIfAbsentRight(K key,V value){
        synchronized (kvMap){
            V old = kvMap.get(key);
            if (old != null){
                return old;
            }
            kvMap.put(key,value);
            return null;
        }
    }

    public void put(K key,V value){
        kvMap.put(key,value);
    }
}
