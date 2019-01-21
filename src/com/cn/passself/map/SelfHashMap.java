package com.cn.passself.map;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by shihuaxian on 2018/7/10.
 */
/*public class SelfHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>,Cloneable,Serializable{

    static final int DEFAULT_INITIAL_CAPACITY = 4;

    static final int MAXIMUM_CAPICITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UBREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash,K key,V value,Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o){
            if (o == this)
                return true;
            if (o instanceof Map.Entry){
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key,e.getKey()) && Objects.equals(value,e.getValue()))
                    return true;
            }
            return false;
        }
    }

    static final int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //static final HashMapEntity<?,?>[] EMPTY_TABLE = {};

    *//**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @see #put(Object, Object)
     *//*
    *//*public V get(Object key){
        Node<K,V> e;
        return (e = getNode(hash(key),key)) == null ? null : e.value;
    }*//*

    *//**
     * Implements Map.get and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @return the node, or null if none
     *//*
    *//*final Node<K,V> getNode(int hash,Object key){
        
    }*//*


}*/
