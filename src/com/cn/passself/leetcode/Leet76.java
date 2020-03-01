package com.cn.passself.leetcode;

public class Leet76 {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n){
            return "";
        }
        //转化成数组，提升查找速度
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        int[] map=new int[256];//利用ASSII码做映射，比hashmap效率高
        for(int i=0;i<n;i++){
            map[T[i]]++;
        }
        int start=-1;
        int L=0,R=0;//滑动窗口[L,R]
        int count=0;//保存窗口里已经找到了多少字符
        int min=m+1;
        while(L<=m-n&&R<m){
            map[S[R]]--;
            if(map[S[R]]>=0){
                count++;
            }
            if(count==n){
                while(map[S[L]]<0){//L尽量往左移动
                    map[S[L]]++;
                    L++;
                }
                if(R-L<min){//记录位置
                    min=R-L;
                    start=L;
                }
                map[S[L++]]++;//L继续右移一位，进行下次寻找
                count--;
            }
            R++;
        }
        if(min<m+1){
            return s.substring(start,start+min+1);
        }
        return "";
    }

    public String minWindow2(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] tempArray = new int[256];
        for(int i=0;i<t.length();i++){
            tempArray[t.charAt(i)]++;
        }
        int[] sempArray = new int[256];
        int l = 0, r = 0; //window[l,r)
        int count = 0;
        int minLength = s.length() + 1, startIndex = -1;
        while(l<s.length()){
            if(r<s.length() && count < t.length()){//r 向右滑动一个
                sempArray[s.charAt(r)]++;
                if(sempArray[s.charAt(r)] <= tempArray[s.charAt(r)])
                    count++;
                r++;
            }else{
                if(count == t.length() && r-l < minLength){//更新最小字符串的长度和开始索引
                    minLength = r-l;
                    startIndex = l;
                }
                //l 向左滑动一个
                sempArray[s.charAt(l)]--;
                if(sempArray[s.charAt(l)] < tempArray[s.charAt(l)])
                    count--;
                l++;
            }
        }
        if(startIndex != -1)
            return s.substring(startIndex,startIndex+minLength);
        return "";
    }
}
