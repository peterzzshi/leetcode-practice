package com.leetcode.sametree;

import com.leetcode.common.TreeNode;

public class Solution {
    public boolean isSameTree(final TreeNode p, final TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }
}