package com.cn.passself.test;

/**
 * Created by shx on 17/2/22.
 */
public class BreakAndContinue {

    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            if (i == 74) break;
            if(i % 9 != 0) continue;
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            new Rock(i);
        }
    }
}

class Rock{
    Rock(int i){
        System.out.println(
                "Creating Rock number " + i);
    }
}
