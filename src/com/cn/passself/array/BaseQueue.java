package com.cn.passself.array;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by shihuaxian on 2017/12/1.
 *
 * 内存映射文件的基本概念以及java中的用法，在日常普通的文件读写中，我们用的比较少，
 * 但在一些系统程序中，它却是经常被用到的一把利器，可以高效的读写大文件，且能实现不同程序间的通讯
 *
 * 利用内存映射文件，我们设计和实现了一个简单的队列，消息可持久化，可以实现跨程序的生产者/消费者通讯这个消息队列的功能、用法、设计和实现代码
 */
public class BaseQueue {

    // 队列最多消息个数，实际个数还会减1
    private static final int MAX_MSG_NUM = 1020*1024;
    // 消息体最大长度
    private static final int MAX_MSG_BODY_SIZE = 1020;
    // 每条消息占用的空间
    private static final int MSG_SIZE = MAX_MSG_BODY_SIZE + 4;
    // 队列消息体数据文件大小
    private static final int DATA_FILE_SIZE = MAX_MSG_NUM * MSG_SIZE;
    // 队列元数据文件大小 (head + tail)
    private static final int META_SIZE = 8;


    private MappedByteBuffer dataBuf;
    private MappedByteBuffer metaBuf;

    public BaseQueue(String path,String queueName) throws IOException{
        if (path.endsWith(File.separator)){
            path += File.separator;
        }
        RandomAccessFile dataFile = null;
        RandomAccessFile metaFile = null;

        try {
            dataFile = new RandomAccessFile(path + queueName + ".data","rw");
            metaFile = new RandomAccessFile(path + queueName + ".meta","rw");

            dataBuf = dataFile.getChannel().map(FileChannel.MapMode.READ_WRITE,0,DATA_FILE_SIZE);
            metaBuf = metaFile.getChannel().map(FileChannel.MapMode.READ_WRITE,0,META_SIZE);
        }finally {
            if (dataFile != null) {
                dataFile.close();
            }
            if (metaFile != null) {
                metaFile.close();
            }
        }
    }

    private int head(){
        return metaBuf.getInt(0);
    }

    private void head(int newHead){
        metaBuf.putInt(0,newHead);
    }

    private int tail(){
        return metaBuf.getInt(4);
    }

    private void tail(int newTail){
        metaBuf.putInt(4,newTail);
    }

    //判断队列是空还是满
    private boolean isEmpty(){
        return head() == tail();
    }

    private boolean isFull(){
        return ((tail() + MSG_SIZE) % DATA_FILE_SIZE) == head();
    }

    /**
     * 基本逻辑是：
     * 如果消息太长或队列满，抛出异常。
     * 找到队列尾，定位到队列尾，写消息长度，写实际数据。
     * 更新队列尾指针，如果已到文件尾，再从头开始。
     * @param data
     * @throws IOException
     * 入队
     */
    public void enqueue(byte[] data) throws IOException{
        if (data.length > MAX_MSG_BODY_SIZE){
            throw new IllegalArgumentException("msg size is " + data.length
                    + ", while maximum allowed length is " + MAX_MSG_BODY_SIZE);
        }

        if (isFull()){
            throw new IllegalStateException("queue is full");
        }

        int tail = tail();
        dataBuf.position(tail);
        dataBuf.putInt(data.length);
        dataBuf.put(data);

        if (tail + MSG_SIZE >= DATA_FILE_SIZE){
            tail(0);
        }else {
            tail(tail + MSG_SIZE);
        }
    }

    //出队列
    public byte[] dequeue() throws IOException{
        if (isEmpty()){
            return null;
        }

        int head = head();
        dataBuf.position(head);
        int length = dataBuf.getInt();
        byte[] data = new byte[length];
        dataBuf.get(data);

        if (head + MSG_SIZE >= DATA_FILE_SIZE){
            head(0);
        }else {
            head(head + MSG_SIZE);
        }

        return data;
    }
}
