package com.cn.passself.proxy.priciple;

import java.lang.reflect.Proxy;

/**
 * 参考:https://www.cnblogs.com/midiyu/p/7878609.html
 * JDK动态代理原理
 *  java 动态代理的入口是从Proxy.newInstance()方法中开始的, 通过这个方法JVM替我们生成一个实现了继承指定接口CakeMachine
 *  的代理类ApricotHandler实例.从Proxy.newInstance()源码中可以看到首先调用了getProxyClass0()方法，该方法返回一个class实例对象
 *  该实例对象其实就是ApricotHandler的class对象. 接着获取其构造方法对象，最后生成该class对象的实例。其实这里主要是这个getProxyClass0()
 *  具体操作从proxyClassCache（k，v，已经加载过的） 中获取对应的class
 */
public class CacheShop{

    public static void main(String[] args) {
        //静态代理
        FruitCakeMachineProxy machineProxy = new FruitCakeMachineProxy(new FruitCacheMachine());
        machineProxy.makeCake();


        CakeMachine cakeMachine = new FruitCacheMachine();
        ApricotHandler handler = new ApricotHandler(cakeMachine);
        CakeMachine fruitCakeProxy =(CakeMachine) Proxy.newProxyInstance(cakeMachine.getClass().getClassLoader(),
                cakeMachine.getClass().getInterfaces(),handler);
        fruitCakeProxy.makeCake();

        CakeMachine fruitProxy = (CakeMachine) DynamicProxyHandler.newProxyInstance(cakeMachine);
        fruitProxy.makeCake();
    }
}