package com.cn.passself.test;

/**
 * Created by shx on 2017/7/13.
 */
public enum Size {
    SMALL(10){
        @Override
        public void onChosen() {
            System.out.println(this.getId());
        }
    },MEDIUM(20){
        @Override
        public void onChosen() {
            System.out.println(this.getId());
        }
    },BIG(30){
        @Override
        public void onChosen() {
            System.out.println(this.getId());
        }
    };
    private int id;

    private Size(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public abstract void onChosen();
}
