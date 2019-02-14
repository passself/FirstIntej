package com.cn.passself.leetcode;

/**
 * Created by shx on 2019/2/13.
 */
public class Leet977 {

    public static void main(String[] args) {
        int[] A = new int[]{-4,-1,0,3,10};
        int[] result = sortedSqueres(A);
        System.out.println(result.toString());
    }

    public static int[] sortedSqueres(int[] A){

        if (A != null && A.length > 0) {
            int length = A.length;
            int result[] = new int[length];
            for (int left=0, right= length-1, index = length-1; left<=right; --index){

                System.out.print("before index ="+index+" left ="+left+" right=:"+right) ;
                int temp = Math.abs(A[left]) > Math.abs(A[right])
                        ? A[left++]  : A[right--] ;
                System.out.println("  index ="+index+" left ="+left+" right=:"+right + " temp ="+temp);
                result[index] = temp * temp;
            }
            return result;
        }else{
            return A;
        }
    }
}
