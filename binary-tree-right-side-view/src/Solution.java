import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(final TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        final Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        final List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            final int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                final TreeNode treeNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return result;
    }
}