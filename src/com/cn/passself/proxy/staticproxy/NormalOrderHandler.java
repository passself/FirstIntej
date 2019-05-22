package com.cn.passself.proxy.staticproxy;

public class NormalOrderHandler implements OrderHandler {

    @Override
    public void handler(String orderId) {
        System.out.println("NormalOrderHandler.handler():orderId:"+orderId);
    }
}
