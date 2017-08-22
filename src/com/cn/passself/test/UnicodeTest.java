package com.cn.passself.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by shx on 2017/6/22.
 */
public class UnicodeTest {

    public static void main(String[] args){
        String str = "ÀÏÂí";
        try{
            String newStr = new String(str.getBytes("windows-1252"),"GB18030");
            System.out.println(newStr);


            String[] charsets = new String[]{"windows-1252", "GB18030", "Big5", "UTF-8"};
            for (int i = 0; i < charsets.length; i++) {
                for (int j = 0; j < charsets.length; j++) {
                    if (i != j) {
                        String s = new String(str.getBytes(charsets[i]), charsets[j]);
                        System.out.println("---- 原来编码(A)假设是: "+charsets[j]+", 被错误解读为了(B): "+charsets[i]);
                        System.out.println(s);
                        System.out.println();
                    }
                }
            }
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
