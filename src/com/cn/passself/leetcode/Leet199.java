package com.cn.passself.leetcode;
import	java.util.ArrayList;
import	java.util.Stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Leet199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<TreeNode> ();
        Stack<Integer> depthStack = new Stack<Integer> ();
        nodeStack.push(root);
        depthStack.push(0);

        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null){
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth,depth);

                //如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)){
                    rightmostValueAtDepth.put(depth,node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer> ();
        for (int depth = 0; depth <= max_depth;depth++){
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }

    int level = -1;

    /**
     * 递归解法
     * 设定一个全局变量记录当前插入ans的最大层数，递归先序遍历右子树即可得到二叉树的右视图。
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        traversingBinaryTree(root,0,ans);
        return ans;
    }

    private void traversingBinaryTree(TreeNode root,int n,List<Integer> ans){
        if (root == null){
            return;
        }
        if (n>level){
            level = n;
            ans.add(root.val);
        }
        traversingBinaryTree(root.right,n+1,ans);
        traversingBinaryTree(root.left,n+1,ans);
    }
}
