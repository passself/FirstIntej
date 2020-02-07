package com.cn.passself.proxy.priciple;

public class FruitCacheMachine implements CakeMachine {

    @Override
    public void makeCake() {
        System.out.println("making a Fruit Cake...");
        System.out.println("adding apricot...");
    }
}
