package com.cn.passself.proxy.invocation;

import com.cn.passself.proxy.staticproxy.MaxOrderHandler;
import com.cn.passself.proxy.staticproxy.OrderHandler;

public class NormalApplicationClass {

    public void handlerOrder(OrderHandler orderHandler,String orderId){
        //创建处理器对象
        OrderHandlerProxy proxy = new OrderHandlerProxy();
        //为传入的实现了OrderHandler接口的对象创建代理并实例化对象
        OrderHandler handler = (OrderHandler) proxy.bind(orderHandler);
        handler.handler(orderId);

        System.out.println(handler.toString());
    }

    public static void main(String[] args) {
        NormalApplicationClass app = new NormalApplicationClass();
        app.handlerOrder(new MaxOrderHandler(),"0123456789999");
    }
}
