public class Solution {
    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}