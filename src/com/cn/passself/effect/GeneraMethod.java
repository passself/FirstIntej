package com.cn.passself.effect;

import java.util.*;

/**
 * Created by shihuaxian on 2018/1/9.
 * 泛型方法
 */
public class GeneraMethod {

    public static Set union(Set s1,Set s2){//未指定通配符
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> union2(Set<E> s1,Set<E> s2){
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        //会报错，因为类型不同，方法本身没有检查机制
        /*Set<String> guys = new HashSet<>();
        guys.add("A");
        guys.add("B");
        Set<Integer> second = new HashSet<>();
        second.add(1);
        second.add(2);
        Set<String> result = union(guys,second);
        System.out.println(result);*/
        //union2限定了类型
        Set<String> first = new HashSet<>();
        first.add("A");
        first.add("B");
        Set<String> second = new HashSet<>();
        second.add("C");
        second.add("D");
        Set<String> result2 = union2(first,second);
        System.out.println(result2);

        Map<String,List<String>> anagrams = new HashMap<String,List<String>>();//这样写代码冗余
        Map<String,List<String>> anagrams2 = generaHashMap();//这样写简单很多

        //测试UnaryFunction
        String[] strings = {"a","b","c"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s: strings){
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1,2.0,3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number num:numbers){
            System.out.println(sameNumber.apply(num));
        }
    }

    public static<K,V> HashMap<K,V> generaHashMap(){//泛型的单例简单工厂
        return new HashMap<K, V>();
    }

    public interface UnaryFunction<T>{
        T apply(T arg);
    }

    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        public Object apply(Object arg){
            return arg;
        }
    };

    public static <T> UnaryFunction<T> identityFunction(){
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public interface Comparable<T>{
        int compare(T o);
    }

    public static <T extends Comparable<T>> T max(List<T> list){
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()){
            T t = i.next();
            if (t.compare(result)> 0) {
                result = t;
            }
        }
        return result;
    }
}
