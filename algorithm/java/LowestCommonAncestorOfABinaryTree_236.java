import entity.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree_236 {
    TreeNode result = null;

    /**
     * 递归，深度优先遍历
     * 深度优先遍历到叶子节点，
     * 返回左右子树是否有某一个节点，
     * 如果左右子树都有 或者
     * 有一个节点等于子节点且有一个节点在左子树或右子树，
     * 因为所有节点的值都是唯一的。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean leftSon = dfs(root.left, p, q);
        boolean rightSon = dfs(root.right, p, q);

        // 如果左右子树都有 或者 有一个节点等于子节点且有一个节点在左子树或右子树（所有节点的值都是唯一的）
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) &&
                (leftSon || rightSon))) {
            result = root;
        }
        return leftSon || rightSon || root.val == p.val || root.val == q.val;
    }
}
