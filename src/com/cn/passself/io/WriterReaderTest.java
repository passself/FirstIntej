package com.cn.passself.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by shihuaxian on 2017/11/22.
 */
public class WriterReaderTest {
    static String filePath = "//Users/shihuaxian/Documents/temp.txt";

    public static void main(String[] args) throws Exception{
        //writeContentToFile();
        writeContentToFileByFileWriter();
        readContentFromFile();
        readFromFileByArrayReader();
    }

    public static void readContentFromFile() throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream(filePath),"utf-8");

        char[] buf = new char[1024];
        int charRead = reader.read(buf);
        System.out.println(new String(buf,0,charRead));
        reader.close();
    }

    public static void writeContentToFile() throws IOException{
        Writer writer = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
        String addContent = "添加一个新的老马";
        writer.append(addContent);
        writer.close();
    }

    /**
     * 需要注意的是，FileReader/FileWriter不能指定编码类型，只能使用默认编码，如果需要指定编码类型，
     * 可以使用InputStreamReader/OutputStreamWriter。
     *
     */
    //实用File
    public static void writeContentToFileByFileWriter() throws IOException{
        Writer writer = new FileWriter(filePath,true);
        String addContent = "--添加一个新的老马";
        writer.append(addContent);
        writer.close();
    }

    public static void readFromFileByArrayReader() throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream(filePath),"utf-8");

        CharArrayWriter writer = new CharArrayWriter();
        char buf[] = new char[1024];
        int charsRead = 0;
        while ((charsRead = reader.read(buf)) != -1){
            writer.write(buf,0,charsRead);
        }
        System.out.println(writer.toString());
        reader.close();
    }

    /**
     * PrintWriter是一个非常方便的类，
     * 可以直接指定文件名作为参数，
     * 可以指定编码类型，可以自动缓冲，
     * 可以自动将多种类型转换为字符串，
     * 在输出到文件时，可以优先选择该类
     */
    public static void writeStudents(List<Student> students) throws IOException{
        PrintWriter writer = new PrintWriter("students.txt");
        try{
            for(Student s : students){
                writer.println(s.getName()+","+s.getAge()+","+s.getScore());
            }
        }finally{
            writer.close();
        }
    }

    /**
     * 拷贝Reader到Writer
     * @param input
     * @param writer
     * @throws IOException
     */
    public static void copy(final Reader input,final Writer writer) throws IOException{
        char[] buf = new char[4096];
        int charRead = 0;
        while ((charRead = input.read()) != -1){
            writer.write(buf,0,charRead);
        }
    }

    /**
     * 将文件全部内容读入到一个字符串
     * @param fileName
     * @param encoding
     * @return
     */
    public static String readFileToString(final String fileName,final String encoding) throws IOException{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encoding));
            StringWriter writer = new StringWriter();
            copy(reader,writer);
            return writer.toString();
        }finally {
            if(reader!=null){
                reader.close();
            }
        }
    }

    /**
     * 将字符串写到文件
     * @param fileName
     * @param data
     * @param encoding
     * @throws IOException
     */
    public static void writeStringToFile(final String fileName,final String data,final String encoding) throws IOException{
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(fileName), encoding);
            writer.write(data);
        }finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    /**
     * 按行将多行数据写入文件
     * @param filename
     * @param encoding
     * @param lines
     * @throws IOException
     */
    public static void writeLines(final String filename, final String encoding, final Collection<?> lines) throws IOException{
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename,encoding);
            for (Object line:lines) {
                writer.println(line);
            }
        }finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    /**
     * 按行将文件内容读到一个列表中
     * @param fileName
     * @param encoding
     * @return
     * @throws IOException
     */
    public static List<String> readLines(final String fileName,final String encoding) throws IOException{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encoding));
            List<String> list = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                list.add(line);
                line = reader.readLine();
            }
            return list;
        }finally {
            if (reader != null){
                reader.close();
            }
        }
    }

    /**
     * 小结:在java中以字符流的方式读写文本文件，我们强调用二进制思维，文本文件与二进制的区别编码
     * 以及字符流与字节流不同，我们介绍了各种字符流，scanner以及标准流。
     *
     * 写文件的时候，优先考虑PrintWriter,因为它实用方便，支持自动缓冲，支持指定编码类型，支持类型转换等。
     * 读文件时，如果需要指定编码类型，需要使用InputStreamReader,不需要，可使用FileReader,但都应该考虑在外面包上缓冲类BufferedReader
     */
}
