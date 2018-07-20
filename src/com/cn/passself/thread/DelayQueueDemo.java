package com.cn.passself.thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shihuaxian on 2018/2/28.
 * DelayQueue可以实现定时任务
 *
 * 其他阻塞队列
 * {@link java.util.concurrent.SynchronousQueue}
 * 和
 * {@link java.util.concurrent.LinkedTransferQueue}
 */
public class DelayQueueDemo {
    private static final AtomicLong taskSequencer = new AtomicLong(0);

    static class DelayTask implements Delayed{
        private long runTime;
        private long sequence;
        private Runnable task;

        public DelayTask(int delayedSeconds,Runnable task){
            this.runTime = System.currentTimeMillis() + delayedSeconds *1000;
            this.sequence = taskSequencer.getAndIncrement();
            this.task = task;
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this){
                return 0;
            }
            if (o instanceof DelayTask){
                DelayTask other = (DelayTask) o;
                if (runTime < other.runTime){
                    return -1;
                }else if (runTime > other.runTime){
                    return 1;
                }else if (sequence < other.sequence){
                    return -1;
                }else {
                    return 1;
                }
            }
            throw new IllegalArgumentException();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        public Runnable getTask(){
            return task;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> tasks = new DelayQueue<>();
        tasks.put(new DelayTask(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("execute delayed task");
            }
        }));
        DelayTask task = tasks.take();
        task.getTask().run();
    }
}
