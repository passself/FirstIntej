package com.cn.passself.leetcode;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Leet67 {
    public String addBinary(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int len = a.length() + 1;
        char[] newCharArray = new char[len];
        int flag = 0;
        int num = 0;
        int gap = a.length() - b.length();
        for (int i = a.length() - 1; i >= gap; i--) {
            num = flag + a.charAt(i) + b.charAt(i - gap) - '0' * 2;
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        for (int i = gap - 1; i >= 0; i--) {
            num = flag + a.charAt(i) - '0';
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        if (flag == 1) {
            newCharArray[0] = '1';
        }
        if (newCharArray[0] == '1') {
            return new String(newCharArray);
        }
        return new String(newCharArray, 1, a.length());
    }

    public String addBinary2(String a, String b){
        StringBuilder ans = new StringBuilder();
        int ca = 0; //是否进一位
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sum +=( j >= 0 ? b.charAt(j) - '0' : 0);
            // 如果二者都为1  那么sum%2应该刚好为0 否则为1
            ans.append(sum % 2);
            //如果二者都为1  那么ca 应该刚好为1 否则为0
            ca = sum / 2;
        }
        // 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public String addBinaryBig(String a, String b) {
        BigInteger aNum =new BigInteger(a,2) ;
        BigInteger bNum =new BigInteger(b,2) ;
        BigInteger ans = aNum.add(bNum);
        String strSum=ans.toString(2);
        return strSum;
    }

}
