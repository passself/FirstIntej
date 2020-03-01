package com.cn.passself.leetcode;

public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb =  new StringBuilder();
        for (Character c : s.toCharArray()){
            if(c == ' '){
                sb.append("20%");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String replaceSpace2(String s) {

        int length = s.length();

        char[] chars = new char[length*3];
        int index = 0;
        for (int i = 0; i < length;i++){
            char c = s.charAt(i);
            if (c == ' '){
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            }else{
                chars[index++] = c;
            }
        }
        String newStr = new String(chars,0,index);
        return newStr;
    }

    public static void main(String[] args) {
        String s = "12 38 ad b";
        System.out.println(replaceSpace2(s));
    }
}
