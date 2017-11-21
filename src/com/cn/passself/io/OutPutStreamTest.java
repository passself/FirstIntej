package com.cn.passself.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by shihuaxian on 2017/11/21.
 */
public class OutPutStreamTest {
    static String filePath = "//Users/shihuaxian/Documents/temp.txt";

    public static void main(String[] args){
        ByteArrayOutTest();
        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            String data = "hello, 123, 老马";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
            outputStream.close();

            InputStream fis = new FileInputStream(filePath);
            byte[] readBuffer = new byte[1024];
            //方法一
            int byteRead = fis.read(readBuffer);
            String dataRead = new String(readBuffer,0,byteRead,"UTF-8");
            System.out.println(dataRead);
            //fis.close();

            //方法二单个字节读入
            /*int b = -1;
            int bytesRead2 = 0;
            while ((b = fis.read()) != -1){
                readBuffer[bytesRead2++] = (byte) b;
            }
            String dataRead2 = new String(readBuffer,0,bytesRead2,"UTF-8");
            System.out.println("第2次 "+dataRead2);*/

            /*int off = 0;
            int bytesRead3 = 0;
            while ((bytesRead3 = fis.read(readBuffer,off,1024-off))!= -1){
                off += bytesRead3;
            }
            String dataRead3 = new String(readBuffer,0,off,"UTF-8");
            System.out.println("第3次 "+dataRead3);*/
            fis.close();
            //感觉第一种方法简单
        }catch (IOException e){
            e.printStackTrace();
        }finally {
        }
    }

    public static void ByteArrayOutTest(){
        try {
            InputStream ips = new FileInputStream(filePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead= ips.read(buf))!= -1){
                baos.write(buf,0,bytesRead);
            }
            String data = baos.toString("UTF-8");
            System.out.println("ByteArrayOutTest is:"+data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 拷贝输入流到输出流
     * @param input
     * @param outputStream
     * @throws IOException
     */
    public static void copy(InputStream input,OutputStream outputStream) throws IOException{
        byte[] buf = new byte[4096];
        int bufferedRead = 0;
        while ((bufferedRead = input.read(buf)) != -1){
            outputStream.write(buf,0,bufferedRead);
        }
    }

    //将文件读入字节数组
    public static byte[] readFileToByteArray(String fileName) throws IOException{
        InputStream is = new FileInputStream(fileName);
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        try {
            copy(is,bops);
            return bops.toByteArray();
        }finally {
            is.close();
        }
    }

    //将字节数组写到文件
    public static void writeByteArrayToFile(String fileName,byte[] data) throws IOException{
        OutputStream output = new FileOutputStream(fileName);
        try {
            output.write(data);
        }finally {
            output.close();
        }
    }
}
