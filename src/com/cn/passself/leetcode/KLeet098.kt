package com.cn.passself.leetcode

/**
 * kotlin 版本
 */
class KLeet098 {
    inner class TreeNode internal constructor(internal var value: Int) {
        internal var left: TreeNode? = null
        internal var right: TreeNode? = null
    }

    internal var last = -Double.MAX_VALUE

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        //采用中序遍历来判断
        if (isValidBST(root.left)) {
            if (last < root.value) {
                last = root.value.toDouble()
                return isValidBST(root.right)
            }
        }
        return false
    }

}