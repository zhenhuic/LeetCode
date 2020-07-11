import entity.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBSToGreaterTree_538 {
    int sum = 0;
    /**
     * 设置一个全局变量，表示比当前节点大的节点的和，
     * 然后采用反向的中序遍历更新节点值
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
