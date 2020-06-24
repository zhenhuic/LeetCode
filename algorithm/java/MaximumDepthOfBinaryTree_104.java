import entity.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree_104 {
    int md = 0;

    /**
     * 深度优先遍历
     * 更新最大值
     */
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return md;
    }

    private void dfs(TreeNode root, int depth) {
        if (root != null) {
            depth++;
            if (depth > md) md = depth;

            dfs(root.left, depth);
            dfs(root.right, depth);
        }
    }
}
