package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode989 {

    //超时
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<Integer>();
        if (A.length == 0) return list;

        int flag = 0, i = A.length - 1, temp = 0;

        while (i >= 0 || K > 0) {

            temp = i >= 0 ? A[i] + K % 10 + flag : K % 10 + flag;
            list.add(temp % 10);
            flag = temp / 10;
            i--;
            K = K / 10;
        }
        if (flag == 1) list.add(1);

        Collections.reverse(list);
        return list;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {

        String k = String.valueOf(K);
        int[] kArray = new int[k.length()];

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <= kArray.length - 1; i++) {
            kArray[i] = Integer.parseInt(String.valueOf(k.charAt(i)));
        }//拆分成k数组

        if (kArray.length > A.length) {
            int[] temp = kArray;
            kArray = A;
            A = temp;
        }//判断长度 以防k数组长度大于A数组
        int innercircle = A.length - 1;
        for (int i = kArray.length - 1; i >= 0; i--) {
            A[innercircle] = A[innercircle] + kArray[i];
            innercircle--;
        }//将k数组加到A数组
        for (int m = A.length - 1; m >= 0; m--) {

            if (m == 0 && A[m] < 10) {
                for (int j : A) {
                    res.add(j);
                }
                return res;

            } else if (m == 0 && A[m] == 10) {
                res.add(1);
                A[m] = 0;
                for (int j : A) {
                    res.add(j);
                }
                return res;

            } else if (m == 0 && A[m] > 10) {
                A[m] = A[m] % 10;
            }
            if (A[m] % 10 != 0 && A[m] > 10) {
                A[m - 1]++;
                A[m] = A[m] % 10;
            } else if (A[m] == 10) {
                A[m - 1]++;
                A[m] = 0;
            }
        }//对数组每个位置做进位处理
        res.add(1);
        for (int j : A) {
            res.add(j);
        }
        return res;
    }

    public static List<Integer> addToArrayForm3(int[] A, int K){
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<> ();
        while(K%10 !=0){
            list.add(K%10);
            K = K/10;
        }
        int i = A.length-1,j = list.size()-1;
        int carry =  0;

        int forLength = 0;
        if(i>j){
            forLength = j;
        }else if (i < j) {
            forLength = i;
        }else {
            forLength = i;
        }

        while (forLength >=0){
            int a = A[i] + list.get(j)+carry;
            carry = a /10;
            int tmp = a%10;
            result.add(tmp);
            i--;
            j--;
            forLength--;
        }

        int lastLength = i>j? i-forLength:j-forLength;
        while (lastLength >=0){
            if(i>j){
                int lastRes = A[i] + carry;
                carry =0;
                result.add(lastRes);
            }
            lastLength--;
        }


        if (carry >0) result.add(carry);
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,0,0}; int k = 34;
        System.out.println(addToArrayForm(A,k));
    }
}
