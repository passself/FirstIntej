package com.cn.passself.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by shihuaxian on 2017/11/28.
 * 引用 https://juejin.im/post/5862658c61ff4b0068ae63f3
 *  文件的一些操作
 */
public class FileOperate {

    public static void main(String[] args){

    }

    /**
     * 列出当前目录下的所有后缀为.txt的文件
     * @return
     *
     * 我们创建了个FileNameFilter的匿名内部类对象传递给了listFiles
     */
    public static File[] filterFile(){
        File file = new File(".");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });
        return files;
    }

    /**
     * 计算一个目录下所有文件的大小(包含子目录)
     *
     * @param directory
     * @return
     */
    public static long sizeOfDirectory(final File directory){
        long size = 0;
        if (directory.isFile()){
            return directory.length();
        }else {
            for (File file:directory.listFiles()){
                if (file.isFile()){
                    size += file.length();
                }else {
                    size += sizeOfDirectory(file);
                }
            }
        }
        return size;
    }

    /**
     * 在一个目录下，查找所有给定文件名的文件
     * @param directory
     * @param fileName
     * @return
     */
    public static Collection<File> findFile(final File directory,final String fileName){
        List<File> files = new ArrayList<>();
        for (File f:directory.listFiles()){
            if (f.isFile() && f.getName().equals(fileName)){
                files.add(f);
            }else if (f.isDirectory()){
                files.addAll(findFile(f,fileName));
            }
        }
        return files;
    }

    /**
     * 利用遍历方法，先删除非空目录下的所有文件，再删除文件夹
     * @param file
     */
    public static void deleteRecursively(final File file) throws IOException{
        if (file.isFile()){
            if (!file.delete()){
                throw new IOException("Failed to delete "+file.getCanonicalPath());
            }
        }else if (file.isDirectory()){
            for (File child:file.listFiles()){
                deleteRecursively(child);
            }
            if (!file.delete()) {
                throw new IOException("Failed to delete "
                        + file.getCanonicalPath());
            }
        }
    }
}
