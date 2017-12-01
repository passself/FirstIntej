package com.cn.passself.array;

import java.io.IOException;
import java.util.Random;

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        try {
            BaseQueue queue = new BaseQueue("./","task");
            int i = 0;
            Random rnd = new Random();
            while (true){
                String msg = new String("task"+(i++));
                queue.enqueue(msg.getBytes());
                System.out.println("produce: "+ msg);
                Thread.sleep(rnd.nextInt(1000));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}