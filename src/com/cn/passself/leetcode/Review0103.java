package com.cn.passself.leetcode;

public class Review0103 {
    public static String replaceSpaces(String S, int length) {
        char[] ch = S.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (ch[i] == ' '){
                count++;
            }
        }

        int i = length + count*2 -1;
        int j = length - 1;
        //从后向前遍历
        while(i!=j){
            if(ch[j] == ' '){
                ch[i] = '0';
                ch[i-1] = '2';
                ch[i-2] = '%';
                i = i-3;
            }else{
                ch[i] = ch[j];
                i--;
            }
            j--;
        }
        return String.valueOf(ch).trim();
    }

    public static void main(String[] args) {

        String s = "Mr Jo";

        System.out.println(replaceSpaces(s,13));
    }
}
