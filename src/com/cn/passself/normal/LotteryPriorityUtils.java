package com.cn.passself.normal;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LotteryPriorityUtils {

    private PriorityQueue<Info> queue;

    public void addInfo2Queue(Info info){
        if (queue == null){
            queue = new PriorityQueue<>();
        }
        queue.add(info);
    }
}
