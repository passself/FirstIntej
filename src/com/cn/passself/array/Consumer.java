package com.cn.passself.array;

import java.io.IOException;
import java.util.Random;

/**
 * Created by shihuaxian on 2017/12/1.
 * 引用  https://juejin.im/post/58626ac361ff4b006cf14faf
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException{
        try {
            BaseQueue queue = new BaseQueue("./","task");
            Random rnd = new Random();

            while (true){
                byte[] bytes = queue.dequeue();
                if (bytes == null){
                    Thread.sleep(rnd.nextInt(1000));
                    continue;
                }
                System.out.println("consume: " + new String(bytes, "UTF-8"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
