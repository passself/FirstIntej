package com.cn.passself.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 * 大佬题解链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-ben-dong-tai-gui-hua-jie-fa-by-labuladong/
 */
public class Leet887 {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    //timeout
    private int dp(int K, int N) {
        if (N == 0 || N == 1 || K == 1) {
            return N;
        }
        int miniNum = N;
        for (int i = 1; i <= N; i++) {
            int tMin = Math.max(dp(K - 1, i - 1), dp(K, N - i));
            miniNum = Math.min(miniNum, 1 + tMin);
        }
        return miniNum;
    }

    //空间换时间解法

    /**
     * 上面的计算之所以时间复杂度高，与递归版本的斐波那契数列一样，
     * 就是因为重复计算了很多遍底部节点的值，为了加快这个计算过程，
     * 一个简单的提升方法就是拿空间换时间，把计算的中间结果都存储起来，后面直接查表即可。
     *
     * @param K
     * @param N
     * @return
     *
     * timeout
     */
    public int superEggDrop2(int K, int N) {
        int[][] middleResults = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            middleResults[1][i] = i; // 只有一个鸡蛋的时候
            middleResults[0][i] = 0;//没有鸡蛋 的时候
        }
        for (int i = 0; i <= K; i++) {
            middleResults[i][0] = 0; // 0层
        }
        for (int i = 2; i <= K; i++) {//从第二层开始
            for (int j = 1; j <= N; j++) {
                int tMin = N * N;
                for (int x = 1; x <= j; x++) {
                    tMin = Math.min(tMin, 1 + Math.max(middleResults[i - 1][x - 1], middleResults[i][j - x]));
                }
                middleResults[i][j] = tMin;
            }
        }
        return middleResults[K][N];
    }

    Map<Integer, Integer> cache = new HashMap<>();

    //二分
    public int superEggDropB(int K, int N) {
        if (N == 0)
            return 0;
        else if (K == 1)
            return N;

        Integer key = N * 1000 + K; // K <= 100
        if (cache.containsKey(key))
            return cache.get(key);

        int low = 1, high = N;
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            int lowVal = superEggDropB(K - 1, middle - 1);
            int highVal = superEggDropB(K, N - middle);

            if (lowVal < highVal)
                low = middle;
            else if (lowVal > highVal)
                high = middle;
            else
                low = high = middle;
        }
        int minimum = 1 + Math.min(
                Math.max(superEggDropB(K - 1, low - 1), superEggDropB(K, N - low)),
                Math.max(superEggDropB(K - 1, high - 1), superEggDropB(K, N - high))
        );

        cache.put(key, minimum);

        return cache.get(key);
    }

    /**
     *
     * @param K
     * @param N
     * @return
     */
    public int superEggDropDP(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}
