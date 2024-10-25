import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        final Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        final List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            final List<Integer> level = new ArrayList<>();
            final int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                final TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }
}