package com.cn.passself.algorithm;

import java.util.Arrays;

/**
 * 常见排序算法以及优化
 *
 */
public class Main {
	
	/**
	 * 冒泡排序
	 */
	public static void maoPao(int[] data){
		for(int i = 0;i<data.length-1;i++){
			for(int j=0;j<data.length-1-i;j++){
				if(data[j]>data[j+1]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
			System.out.println("排序第"+(i+1)+"次"+Arrays.toString(data));
		}
	}
	
	/**
	 * 二分算法
	 * 
	 */
	public static void binarySearch(int[] data,int key){
		int left = 0;
		int right = data.length - 1;
		int mid = 0;
		while(left < right){
			mid = (left + right) / 2;
			if(key > data[mid]){
				left = mid;
			}else if(key < data[mid]){
				right = mid;
			}if(key == data[mid]){
				System.out.println("mid ="+mid);
				System.out.println(data[mid]);
				break;
			}
		}
	}

	public static int binarySearchP(int[] nums, int target) {
		// write your code here
		int result = -1;
		int start = 0;
		int end = nums.length - 1;
		int middle = 0;
		while(start+1 < end){
			middle = start + (end - start) /2;
			if(target == nums[middle]){
				end = middle;
			}else if(target > nums[middle]){
				start = middle;
			}else{
				end = middle;
			}
		}
		if (nums[start] == target){
			result = target;
		}
		if (nums[end] == target){
			result = end;
		}
		return result;
	}

	/**
	 * 递归实现
	 * @param arr
	 */
	public static void quickSort(int[] arr){

	}
	
	public static void main(String[] args) {
		/*int[] datas = {1,3,12,43,12,1,342,12};
		maoPao(datas);
		int[] bDatas = {1,4,6,8,10,11,16,17,20};
		binarySearch(bDatas, 11);*/
		int[] nums1 = new int[]{3,4,5,8,8,8,8,10,13,14};
		int[] nums = new int[]{4,5,9,9,12,13,14,15,15,18};
		System.out.println(binarySearchP(nums1,8));
		//System.out.println(binarySearch(nums,8));
		binarySearch(nums,10);
	}

	/**
	 * 快速排序
	 */

}
