package com.cn.passself.proxy.priciple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ApricotHandler implements InvocationHandler {

    private Object object;
    public ApricotHandler(Object obj){
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object result = method.invoke(object,args);
        System.out.println("动态代理 adding apricot...");
        return result;
    }
}
