package com.cn.passself.http;

import java.io.*;
import java.net.Socket;

/**
 * Created by shx on 2017/8/2.
 * 测试的时候
 * 客户端
 */
public class GreetingClient {

    public static void main(String[] args){
        String serveName = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            System.out.println("连接到主机:"+serveName+", 端口号:"+port);
            Socket client = new Socket(serveName,port);
            System.out.println("远程主机地址:"+client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from"+client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream input = new DataInputStream(inFromServer);
            System.out.println("服务器响应: " + input.readUTF());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
