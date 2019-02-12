package com.cn.passself.test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

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

        //
        String regEx = "^^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]{6,16}+$";//一个正则表达式，只含有汉字、数字、字母、下划线不能以下划线开头和结尾
        //String regEx = "^[\\u4e00-\\u9fa5]{1,7}$|^[\\dA-Za-z_]{1,14}$";//一个正则表达式，只含有汉字、数字、字母、下划线不能以下划线开头和结尾

        boolean result = Pattern.compile(regEx).matcher("_shx").matches();
        System.out.println("1 result is:"+result);
        result = Pattern.compile(regEx).matcher("shx1_又").matches();
        System.out.println("2 result is:"+result);
        result = Pattern.compile(regEx).matcher("sh_1223").matches();
        System.out.println("3 result is:"+result);

        result = Pattern.compile(regEx).matcher("sh22121212122112又").matches();
        System.out.println("4 result is:"+result);
        result = Pattern.compile(regEx).matcher("sh__21221又").matches();
        System.out.println("5 result is:"+result);
        result = Pattern.compile(regEx).matcher("被错误解读为了1又").matches();
        System.out.println("6 result is:"+result);
    }
}
