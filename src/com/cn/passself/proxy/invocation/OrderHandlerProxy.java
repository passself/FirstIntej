package com.cn.passself.proxy.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderHandlerProxy implements InvocationHandler {

    //委托类,在这里就相当于实现了OrderHandler的类的对象
    Object target;

    public Object bind(Object object){
        this.target = object;
        //通过proxy静态方法创建代理类，第一个参数为委托类的类加载器
        //第二个参数为委托类实现的接口集，第三个参数是处理类本身
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws
            InvocationTargetException, IllegalAccessException {
        //判断执行的方法是否是我们需要代理的方法handler

        if (method.getName().equalsIgnoreCase("handler")){
            System.out.println("OrderHandlerProxy.invoke.before");

            String orderId = (String) args[0];

            //对orderId长度进行限制
            if (orderId.length() > 10){
                orderId = orderId.substring(0,10);
            }

            //通过反射调用委托类的方法
            Object invoke = method.invoke(target,orderId);
            System.out.println("OrderHandlerProxy.invoke.after");

            return invoke;
        }else {
            //当前的执行方法不是我们需要代理的方法时不做操作直接委托相关方法
            System.out.println("Method.name:"+method.getName());
            return method.invoke(target,args);
        }
    }
}
