package com.cn.passself.normal;

public class PairUtil {

    public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
        return p1.getKey().equals(p2.key) && p1.getValue().equals(p2.getValue());
    }

    public static class Pair<K,V>{

        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    public interface Comparable<T>{
        public int compareTo(T o);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray,T elem){
        int count = 0;
        for (T e:anArray){
            if (e.compareTo(elem) >0){
                ++count;
            }
        }
        return count;
    }
}


