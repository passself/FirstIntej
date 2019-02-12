package com.cn.passself.leetcode;

/**
 * Created by shx on 2019/1/27.
 */
public class Let467 {
    public int findSubstringInWraproundString2(String p) {
        int totalCount = 0;
        int i = 0;
        int[] constants = new int[26];
        while (i < p.length()) {
            int n = i;
            while (n + 1 < p.length() && (int) p.charAt(n + 1) % 26 == (p.charAt(n) + 1) % 26) n++;
            for (int a = i; a <= n; a++) {
                constants[p.charAt(a) - 'a'] = Math.max(constants[p.charAt(a) - 'a'], n - a + 1);
            }
            i = n + 1;
        }
        for (int j = 0; j < 26; j++) {
            totalCount += constants[j];
        }
        return totalCount;
    }

    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];

        // store longest contiguous substring ends at current position.
        int maxLength = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLength++;
            }
            else {
                maxLength = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLength);
        }

        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }

    public int findSubstringInWraproundStringPoint(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] ways = new int[125];
        char[] cs = p.toCharArray();
        int left = 0;
        int right = 1;
        // NOTE: even if right == cs.length, can still go into the loop, to handle the "a" case (single char)
        while (right <= cs.length) {
            while (right < cs.length && ((cs[right] - cs[right-1] == 1) || (cs[right] == 'a' && cs[right-1] == 'z'))) {
                right++;
            }
            while (left < right) {
                ways[cs[left]] = Math.max(ways[cs[left]], right - left);
                left++;
            }
            right++;
        }
        int sum = 0;
        for (int way : ways) {
            sum += way;
        }
        return sum;
    }
}
