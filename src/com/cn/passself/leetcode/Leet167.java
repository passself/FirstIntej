package com.cn.passself.leetcode;

public class Leet167 {


    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        int left = 0,right = numbers.length - 1;
        while(left <= right){
            if (numbers[left] +numbers[right] == target){
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            if (numbers[left] + numbers[right] <target){
                left++;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {

        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        
        for (int i = 0; i <numbers.length; i++) {
            int index = binarySearch(numbers,target-numbers[i],i+1);
            if (index >0){
                result[0] = i+1;
                result[1] = index+1;
                return result;
            }
        }
        return result;
    }

    public static int binarySearch(int[] numbers,int newTarget,int j){
        int low = j,high = numbers.length -1;
        int mid = 0;
        while(low <= high){
            //mid = (low + high)/2;
            mid = low + (high - low)/2;
            if (numbers[mid] == newTarget) {
                return mid;
            }else if(numbers[mid] < newTarget){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
