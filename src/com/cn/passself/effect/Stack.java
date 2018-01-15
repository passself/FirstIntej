package com.cn.passself.effect;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by shihuaxian on 2018/1/9.
 * 优先考虑泛型
 */
/*public class Stack {//不能使用

    private Object[] elements;

    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];//这里有警告，不能创建不可具体化的类型的数组
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if (size == 0){
            throw  new EmptyStackException();
        }
        Object obj = elements[--size];
        elements[size] = null;
        return obj;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    private void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements,2*size +1);
        }
    }

    public static void main(String[] args){
        Stack<Object> stack = new Stack<Object>();//这里有警告，不能创建不可具体化的类型的数组
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        while(!stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }
    }
}*/
public class Stack<E>{
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack(){
        //elements = new E[] [DEFAULT_INITIAL_CAPACITY];//这里有警告，不能创建不可具体化的类型的数组
        elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];//修改后
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity(){
        if (size == elements.length){
            elements = Arrays.copyOf(elements,2*size + 1);
        }
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public E pop(){
        if (size == 0)
            throw  new EmptyStackException();
        E e = elements[--size];
        elements[size] = null;
        return e;
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        while(!stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
