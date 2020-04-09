package com.cn.passself.leetcode;

public class Compare {

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public int Compare(String str1, String str2) {

        String[] str1Array = str1.split("[._]");
        String[] str2Array = str2.split("[._]");


        int index = 0;
        int minLen = Math.min(str1Array.length, str2Array.length);
        long diff = 0;

        while (index < minLen && (diff = Long.parseLong(str1Array[index]) - Long.parseLong(str2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < str1Array.length; i++) {
                if (Long.parseLong(str1Array[i]) > 0) {
                    return 1;
                }
            }
            for (int i = index; i < str2Array.length; i++) {
                if (Long.parseLong(str2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /*1大,-1小*/
    public static int compare2(String str1, String str2){
        String[] str1Array = str1.split("[._]");
        String[] str2Array = str2.split("[._]");
        int index = 0;
        int minLen = Math.min(str1Array.length, str2Array.length);
        long diff = 0;
        while (index < minLen && (diff = Long.parseLong(str1Array[index])
                - Long.parseLong(str2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < str1Array.length; i++) {
                if (Long.parseLong(str1Array[i]) > 0) {
                    return 1;
                }
            }
            for (int i = index; i < str2Array.length; i++) {
                if (Long.parseLong(str2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }else {
            return diff > 0 ? 1 : -1;
        }
    }
}
