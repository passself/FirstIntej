package com.cn.passself.proxy.staticproxy;

public class MaxOrderHandler implements OrderHandler {
    @Override
    public void handler(String orderId) {
        System.out.println("MaxOrderHandler.handler():orderId:"+orderId);
    }
}
