package com.leetcode.diameterofbinarytree;

import com.leetcode.common.TreeNode;

class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(final TreeNode root) {
        height(root);
        return maxDiameter;
    }

    int height(final TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        maxDiameter = Math.max(leftHeight + rightHeight, maxDiameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}