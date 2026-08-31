package com.leetcode.invertbinarytree;

import com.leetcode.common.TreeNode;

public class Solution {
    public TreeNode invertTree(final TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode tempNode = root.left;
        root.left = root.right;
        root.left = tempNode;

        return root;
    }
}