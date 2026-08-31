package com.leetcode.validatebinarysearchtree;

import com.leetcode.common.TreeNode;

public class Solution {
    public boolean isValidBST(final TreeNode root) {
        return this.dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(final TreeNode treeNode, final long left, final long right) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= left || treeNode.val >= right) {
            return false;
        }

        return this.dfs(treeNode.left, left, treeNode.val) && this.dfs(treeNode.right, treeNode.val, right);
    }
}