import entity.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateBinarySearchTree_98 {
    /**
     * 中序遍历二叉搜索树
     * 判断与前一个节点的比值
     * 8.2 更精简的代码
     */
    TreeNode prior = null;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) return false;
            if (prior != null && prior.val >= root.val) {
                return false;
            }
            prior = root;
            if (!isValidBST(root.right)) return false;
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
