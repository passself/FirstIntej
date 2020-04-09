package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Leet22 {

    //方法一：暴力法

    /**
     * 我们可以生成所有 2^{2n}个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。
     * 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
     * 为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。如果
     * 在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] chars, int pos, List<String> combinations) {
        if (pos == chars.length) {
            if (valid(chars)) {
                combinations.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generateAll(chars,pos+1,combinations);
            chars[pos] = ')';
            generateAll(chars,pos+1,combinations);
        }
    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    /**
     * 方法二：回溯法
     * 我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。
     * 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<> ();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if(open < max){
            cur.append('(');
            backtrack(ans,cur, open +1,close, max);
            cur.deleteCharAt(cur.length() -1);
        }
        if(close < open){
            cur.append(')');
            backtrack(ans,cur, open,close +1,max);
            cur.deleteCharAt(cur.length() -1);
        }
    }
}
