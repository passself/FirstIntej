package com.cn.passself.algorithm;

public class NewQuickSort {

    public void quickSort(int arr[], int left, int right) {
        if (left >= right) return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private int partition(int arr[], int left, int right) {
        int i = left, j = right + 1, pivot = arr[left];
        while (true) {
            while (i < right && arr[++i] > pivot) {
                if (i == right) break;
            }
            while (j > left && arr[--j] < pivot) {
                if (j == left) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
