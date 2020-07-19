import entity.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateBinarySearchTree_98 {
    boolean first = true;
    int prior;

    /**
     * 中序遍历二叉搜索树
     * 判断与前一个节点的比值
     */
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root != null) {
            boolean res = inorderTraversal(root.left);
            if (!res) return false;
            if (first) {  // 不能用 Integer.MIN_VALUE，因为节点值可能就是它
                prior = root.val;
                first = false;
            } else {
                if (root.val > prior) prior = root.val;
                else return false;
            }

            res = inorderTraversal(root.right);
            if (!res) return false;
            return true;
        }
        return true;
    }

    /**
     * 典型的错误思路，这样只能判断父子节点大小关系，
     * 不能判断祖父与子节点的大小
     */
    public boolean isValidBSTError(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val <= root.left.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
