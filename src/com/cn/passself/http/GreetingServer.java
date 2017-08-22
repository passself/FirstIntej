package com.cn.passself.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by shx on 2017/8/2.
 */
public class GreetingServer extends Thread{

    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                System.out.println("等待远程连接，端口号为:"+serverSocket.getLocalPort()+"...");
                Socket socket = serverSocket.accept();
                System.out.println("远程主机地址:"+socket.getRemoteSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());
                DataOutputStream dops = new DataOutputStream(socket.getOutputStream());
                dops.writeUTF("谢谢连接我：" + socket.getLocalSocketAddress() + "\nGoodbye!");
                socket.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String [] args)
    {
        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
