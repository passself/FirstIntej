package com.cn.passself.leetcode;

import java.util.*;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Leet03 {

    public static void main(String[] args) {
        //测试用例
        String test1 = "abcbabcbb";

        System.out.println(lengthestSubStringsIndex(test1));

    }

    //method1 暴力循环
    public static int maxCount(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (allUnique(s,i,j)) ans = Math.max(ans,j-i);
            }
        }
        return ans;
    }

    public static boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if (set.contains(ch)) return  false;
            set.add(ch);
        }
        return true;
    }

    /**
     * method2
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthestSubStrings(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }
        //ans 记录最大count set 只是记录当前容器里面字符
        int i = 0, j = 0,ans = 0;

        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(i< n && j < n){
            if (!set.contains(s.charAt(j))){
                System.out.println("before add -->"+Arrays.toString(set.toArray()));
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
                System.out.println("after add -->"+Arrays.toString(set.toArray()));
            }else{
                System.out.println("before remove -->"+Arrays.toString(set.toArray()));
                set.remove(s.charAt(i++));
                System.out.println("after remove -->"+Arrays.toString(set.toArray()));
            }
        }
        return ans;
    }

    /**
     * method3 索引 abcb 出现第二b字符串的时候直接记录【i，j】= [0,j]变成 【2，j】
     * @return
     */
    public static int lengthestSubStringsIndex(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }
        int ans = 0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0,j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
