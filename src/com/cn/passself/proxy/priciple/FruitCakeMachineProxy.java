package com.cn.passself.proxy.priciple;

public class FruitCakeMachineProxy implements CakeMachine {

    private CakeMachine cakeMachine;

    public FruitCakeMachineProxy(CakeMachine machine){
        this.cakeMachine = machine;
    }

    @Override
    public void makeCake() {
        cakeMachine.makeCake();
        System.out.println("adding apricot...");
    }
}
