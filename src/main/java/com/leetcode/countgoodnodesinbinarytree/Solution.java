package com.leetcode.countgoodnodesinbinarytree;

import com.leetcode.common.TreeNode;

public class Solution {
    public int goodNodes(final TreeNode root) {
        return this.dfs(root, root.val);
    }

    int dfs(final TreeNode treeNode, final int max) {
        if (treeNode == null) {
            return 0;
        }
        return treeNode.val < max ? this.dfs(treeNode.left, max) + this.dfs(treeNode.right, max) : 1 + this.dfs(treeNode.left, treeNode.val) + this.dfs(treeNode.right, treeNode.val);
    }
}