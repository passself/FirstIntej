package com.cn.passself.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * 单词的压缩编码
 */
public class Leet820 {

    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0){
            return 0;
        }
        int length = words.length;
        String[] reverseWords = new String[length];
        for (int i = 0; i < length; i++) {
            String word  = words[i];
            String rword = new StringBuilder(word).reverse().toString();
            reverseWords[i] = rword;
        }

        Arrays.sort(reverseWords);

        int result = 0;
        for (int i =0 ; i < length;i++){
            if (i+1<length && reverseWords[i+1].startsWith(reverseWords[i])){

            }else{
                result += reverseWords[i].length()+1;
            }
        }

        return result;
    }

}
