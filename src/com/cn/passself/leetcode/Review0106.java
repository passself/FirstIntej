package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * 字符串压缩
 */
public class Review0106 {

    public String compressString(String S) {
        if (S == null || S.length() <= 2){
            return S;
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            //如果i与i-1相同，cnt累加
            if (S.charAt(i) == S.charAt(i-1)){
                cnt++;
            }else{
                sb.append(cnt).append(S.charAt(i));
                cnt = 1;
            }
        }
        return sb.append(cnt).length() < S.length() ? sb.toString():S;
    }
}
