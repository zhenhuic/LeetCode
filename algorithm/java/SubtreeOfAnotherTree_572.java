import entity.TreeNode;

/**
 * 572. 另一个树的子树
 */
public class SubtreeOfAnotherTree_572 {
    /**
     * DFS暴力匹配
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    private boolean dfs(TreeNode n, TreeNode t) {
        if (n == null) return false;
        return isSameTree(n, t) || dfs(n.left, t) || dfs(n.right, t);
    }

    private boolean isSameTree(TreeNode n, TreeNode t) {
        if (n == null && t == null) return true;
        if (n == null || t == null || n.val != t.val) return false;
        return isSameTree(n.left, t.left) &&
                isSameTree(n.right, t.right);
    }




    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);

        SubtreeOfAnotherTree_572 sub = new SubtreeOfAnotherTree_572();
        System.out.println(sub.isSubtree(s, t));
    }
}
