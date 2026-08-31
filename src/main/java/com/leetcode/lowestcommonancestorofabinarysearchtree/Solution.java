package com.leetcode.lowestcommonancestorofabinarysearchtree;

import com.leetcode.common.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) {
            return root;
        }

        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }

        if (root.val < p.val) {
            return this.lowestCommonAncestor(root.right, p, q);
        } else {
            return this.lowestCommonAncestor(root.left, p, q);
        }
    }
}