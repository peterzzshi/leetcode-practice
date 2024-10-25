public class Solution {
    public boolean isSubtree(final TreeNode root, final TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            if (this.isSameTree(root.left, subRoot.left) && this.isSameTree(root.right, subRoot.right)) {
                return true;
            }
        }

        return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
    }

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