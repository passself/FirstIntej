package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * 外观数列
 */
public class Leet38 {

    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int count = 1;

            sb = new StringBuilder();
            char[] ss = dp[i - 1].toCharArray();
            int len = ss.length;
            for (int j = 0; j < len - 1; j++) {
                if (ss[j] == ss[j + 1]) {
                    count++;
                    continue;
                }
                sb.append(String.valueOf(count)).append(ss[j]);
                count = 1;
            }
            sb.append(String.valueOf(count)).append(ss[len - 1]);
            dp[i] = sb.toString();
        }
        return dp[n - 1];

        /*String[] dp = new String[n] ;
        dp[0] = "1" ;
        StringBuilder sb = new StringBuilder() ;
        for(int i = 1 ; i < n ; i++){
            int count = 1 ;
            sb = new StringBuilder() ;
            char[] ss = dp[i-1].toCharArray() ;
            int len = ss.length ;
            for(int j = 0 ; j < len - 1 ; j++){
                if(ss[j] == ss[j+1]){
                    count++ ;
                    continue ;
                }
                sb.append(String.valueOf(count)).append(ss[j]) ;
                count = 1 ;
            }
            sb.append(String.valueOf(count)).append(ss[len-1]) ;
            dp[i] = sb.toString() ;
        }
        return dp[n-1] ;*/
    }

    public static String countAndSay2(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0,ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if(c == currentChar){
                    num++;
                }
                else{
                    ans.append((char)('0'+num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char)('0'+num));
            ans.append(currentChar);

        }

        return ans.toString();
    }
}
