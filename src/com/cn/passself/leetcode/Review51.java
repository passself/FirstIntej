package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * <p>
 * 数组中的逆序对
 */
public class Review51 {

    private int res = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        mergeSort(copy, 0, len - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        //求中点 划分左右两个区间 递归排序
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        //利用一个tmp辅助数组 开始对左右两个排序后的区间合并
        int l = left, r = mid + 1, cur = 0;
        int[] tmp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            //左边区间数小于等于右边 左边先放入tmp 并更新左边指针
            if (nums[l] <= nums[r]) {
                tmp[cur] = nums[l++];
                //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
                res += r - (mid + 1);
            } else {
                tmp[cur] = nums[r++];
            }
            cur++;
        }
        //如果右边节点先到右区间边界导致上边while退出
        while (l <= mid) {
            tmp[cur++] = nums[l++];
            //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
            res += r - (mid + 1);
        }
        while (r <= right) {
            tmp[cur++] = nums[r++];
        }

        //将待排序数组 当前排好序的left~right区间重新赋值
        for (int i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }

    }

    /**
     * 官网
     * 思路: 归并排序
     *
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    /**
     * 暴力循环
     *
     * @param nums
     * @return
     */
    public int reversePairs3(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]){
                    res++;
                }
            }
        }
        return res;
    }
}
