package com.cn.passself.leetcode;

public class Leet440 {
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;
        while(k>0){

            long step=calstep(n,curr,curr+1);

            if(k<step){//在这个范围内
                curr*=10;//移动一层
                k--;
            }else{//移动相邻的下一个节点
                k-=step;
                curr=curr+1;
            }

        }
        return curr;
    }

    public long calstep(int n,long n1,long n2){
        int ans=0;
        while(n1<=n){
            ans+=Math.min(n+1,n2)-n1;
            n1*=10;
            n2*=10;
        }
        return ans;
    }

    /**
     * 构造十叉树
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber2(int n, int k) {
        //10叉树
        int currentNode = 1;
        //找数中第K大的元素，即在1号子树下面找K-1大的元素
        k--;
        while (k > 0){
            /* firstNode: 子树的第一个元素 eg：1 11
             * lastNode: 子树的最后一个元素 eg：2 20
             * currentTreeNodes: 当前这个子树有多少个节点，因为这棵树不一定是满10叉树
             */
            long firstNode = currentNode,lastNode = currentNode+1,currentTreeNodes = 0;
            //深度优先，先遍历寻找子树
            while (firstNode <=n){
                //因为这棵树不一定是满10叉树，所以要判断一下，n+1是因为减去firstNode多减了一个元素
                currentTreeNodes += Math.min(lastNode,(long)n+1-firstNode);
                //向下遍历
                firstNode *=10;
                lastNode *=10;
            }
            //子树的子节点比K大，说明在这颗树中，向下递归寻找子树
            if (currentTreeNodes > k){
                k--;
                currentNode *= 10;
            }else{
                //不在树中，需要到下一棵树中找第K-currentTreeNodes大的元素
                k -= currentTreeNodes;
                currentNode++;
            }
        }
        return currentNode;
    }
}
