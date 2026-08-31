package com.leetcode.kthsmallestelementinabst;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kthSmallest(final TreeNode root, final int k) {
        final List<TreeNode> nodes = new ArrayList<>();
        this.inOrder(root, nodes);
        return nodes.get(k - 1).val;
    }

    void inOrder(final TreeNode node, final List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        this.inOrder(node.left, nodes);
        nodes.add(node);
        this.inOrder(node.right, nodes);
    }
}