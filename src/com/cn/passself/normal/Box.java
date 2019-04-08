package com.cn.passself.normal;

public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Box<String> strBox = new Box<>();
        Box<Integer> integerBox = new Box<>();
    }
}
