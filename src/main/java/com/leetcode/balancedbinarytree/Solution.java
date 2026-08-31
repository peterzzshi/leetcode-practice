package com.leetcode.balancedbinarytree;

import com.leetcode.common.TreeNode;

public class Solution {
    public boolean isBalanced(final TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.height(root) != -1;
    }

    int height(final TreeNode node) {
        if (node == null) {
            return 0;
        }

        final int leftHeight = this.height(node.left);
        final int rightHeight = this.height(node.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}