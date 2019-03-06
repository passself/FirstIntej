package com.cn.passself.leetcode;

public class Leet546 {
    int[][][] res;
    int[] boxes;

    private int removeStub(int start, int end, int k) {
        if (start > end) return 0;
        if (res[start][end][k] > 0) return res[start][end][k];
        int ans = removeStub(start, end - 1, 0) + (k + 1) * (k + 1);
        for (int i = start; i < end; i++)
            if (boxes[i] == boxes[end]) {
                ans = Math.max(ans, removeStub(start, i, k + 1) + removeStub(i + 1, end - 1, 0));
            }
        res[start][end][k] = ans;
        return ans;
    }

    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        this.res = new int[n][n][n + 1];
        this.boxes = boxes;
        return removeStub(0, boxes.length - 1, 0);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
        Leet546 leet546 = new Leet546();
        System.out.println(leet546.removeBoxes(array));
    }

    /**
     * 优化后的
     * @param boxes
     * @return
     */
    public int removeBoxes2(int[] boxes) {
        if(boxes == null || boxes.length == 0) return 0;
        int length = boxes.length;
        int[][][] dp = new int[length][length][length];
        return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
    }

    public int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                        calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
}
