import entity.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class BinaryTreeMaximumPathSum_124 {
    int maxSum = Integer.MIN_VALUE;

    /**
     * 递归求子树的最大收益
     * 递归过程中同时计算新的路径和
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;

        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));

        // 新路径的和，只包括当前节点和子节点的最大路径和
        int newPathSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathSum);

        return root.val + Math.max(leftGain, rightGain);
    }
}
