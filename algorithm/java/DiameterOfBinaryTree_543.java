import entity.TreeNode;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree_543 {
    /**
     * 递归求每个节点的到叶节点的最大深度，
     * 以当前节点为路径上的点，那么直径就是左右子树的深度和。
     */
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
