import entity.TreeNode;

/**
 * 617. 合并二叉树
 */
public class MergeTwoBinaryTrees_617 {
    /**
     * 遍历两个二叉树，
     * 以一颗树为主树，将另一棵树接过来。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 == null) {
            t1.left = mergeTrees(t1.left, null);
            t1.right = mergeTrees(t1.right, null);
            return t1;
        } else if (t1 == null && t2 != null) {
            t2.left = mergeTrees(null, t2.left);
            t2.right = mergeTrees(null, t2.right);
            return t2;
        } else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }
}
