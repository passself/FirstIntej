package com.cn.passself.algorithm;

import java.util.Arrays;

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
	
	public static void main(String[] args) {
		int[] datas = {1,3,12,43,12,1,342,12};
		maoPao(datas);
		int[] bDatas = {1,4,6,8,10,11,16,17,20};
		binarySearch(bDatas, 11);
	}
}
