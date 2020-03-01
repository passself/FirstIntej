package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Leet151 {
    public static String reverseWords(String s) {
        String[] temps = s.trim().split(" +");
        Collections.reverse(Arrays.asList(temps));
        return String.join(" ",temps);
    }

    public static void main(String[] args) {
        String s= "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public String reverseWords2(String s) {
        if( s==null|| s.isEmpty())
            return s;
        String[] list = s.split(" ");
        StringBuilder sb  = new StringBuilder();
        for (int i=list.length-1; i>=0; i--){
            if(list[i].isEmpty())
                continue;
            sb.append(list[i]);
            if(i>0)
                sb.append(" ");
        }
        return sb.toString().trim();
    }
}
