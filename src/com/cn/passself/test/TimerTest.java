package com.cn.passself.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shx on 17/2/23.
 */
public class TimerTest {
    private static int count = 0;
    public static void main(String[] args){
        //定时器测试
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count+1)%2;
                System.out.println("bombing..." + new Date().getSeconds());
                new Timer().schedule(new MyTimerTask(),2000 + count * 2000);
            }
        }

        new Timer().schedule(new MyTimerTask(),2000);
    }
}
