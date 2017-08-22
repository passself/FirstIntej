package com.cn.passself.generic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 转自: https://juejin.im/post/581676edda2f60005dc54e58
 * Created by shx on 2017/8/3.
 * 模拟ArrayList
 *
 */
public class DynamicArray<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] elementData;

    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){

        int oldCapacity = elementData.length;

        if (oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity *2;
        if (newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    public void add(E e){
        ensureCapacity(size+1);
        elementData[size++] = e;
    }

    public E get(int index){
        return (E)elementData[index];
    }

    public int size(){
        return size;
    }

    public E set(int index, E e){
        E oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    /*public void addAll(DynamicArray<E> c){
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }*/

    /**
     * <T extends E> 与 <? extends E> 到底有什么关系
     * 它们用的地方不一样
     * 1.<T extends E>用于定义类型参数，它声明了一个类型参数T，可放在泛型类定义中类名后面
     *  泛型方法返回值前面
     * 2.<? extends E> 用于实例化类型参数，它用于实例化泛型变量中的类型参数，只是这个具体类型是未知的，只是知道它是E或者E的某个子类
     */

    /**
     * 第一种写法
     * @param c
     * @param <T>
     */
    public <T extends E> void addAll(DynamicArray<T> c){
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    /**
     * 第二种写法
     * @param c
     */
    public void addAllNew(DynamicArray<? extends E> c){
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    private static <T> void swapInternal(DynamicArray<T> arr,int i,int j){
        T temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    /**
     * 两个数据互换位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(DynamicArray<?> arr,int i,int j){
        swapInternal(arr,i,j);
    }

    /**
     * 将容器中的内容拷贝到dest中
     * @param dest
     * @param src
     * @param <D>
     * @param <S>
     */
    public static <D,S extends D> void copy(DynamicArray<D> dest,DynamicArray<S> src){
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    /**
     * 第二种方式(copy)
     * @param dest
     * @param src
     * @param <D>
     */
    public static <D> void copyNew(DynamicArray<D> dest,DynamicArray<? extends D> src){
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    /**
     * 如果返回值依赖于类型参数，也不能用通配符
     * 比如，计算动态数组中的最大值，如下所示：
     */

    public static <T extends Comparable<T>> T max(DynamicArray<T> arr){
        T max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).compareTo(max) > 0){
                max = arr.get(i);
            }
        }
        return max;
    }

    public static <T extends Comparable<? super T>> T maxNew(DynamicArray<T> arr){
        T max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).compareTo(max) > 0){
                max = arr.get(i);
            }
        }
        return max;
    }

    /**
     *
     * @param dest
     */
    public void copyTo(DynamicArray<E> dest){
        for (int i = 0; i < size; i++) {
            dest.add(get(i));
        }
    }

    /**
     * 超类通配符
     * @param dest
     */
    public void copyToNew(DynamicArray<? super E> dest){
        for (int i = 0; i < size; i++) {
            dest.add(get(i));
        }
    }
}
