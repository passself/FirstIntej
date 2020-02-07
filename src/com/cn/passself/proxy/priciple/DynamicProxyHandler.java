package com.cn.passself.proxy.priciple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    private Object _object;

    public DynamicProxyHandler(Object object){
        this._object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println(getClass().getSimpleName()+"动态代理["+_object.getClass().getSimpleName()+"]的["+method.getName()+"]方法");
        return method.invoke(_object,args);
    }

    public static Object newProxyInstance(Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new DynamicProxyHandler(object));
    }
}
