package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qia-pai-fen-zu-by-shen-shui-bing/
 */
public class Leet914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }
        int result = -1;
        for (int cnt : count) {
            if (cnt > 0) {
                result = result == -1 ? cnt : gcd(result, cnt);
                if (result == 1) {
                    return false;
                }
            }
        }
        return result >=2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
