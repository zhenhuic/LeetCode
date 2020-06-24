import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal_94 {
    /**
     * 迭代算法
     * 栈S;
     * p= root;
     * while(p || S不空){
     *     while(p){
     *         p入S;
     *         p = p的左子树;
     *     }
     *     p = S.top 出栈;
     *     访问p;
     *     p = p的右子树;
     * }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 遍历到最左端，直到为 cur 为 null
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            // 弹出栈顶节点，添加到结果
            TreeNode node = stack.pollLast();
            result.add(node.val);
            // 进入右子树
            cur = node.right;
        }
        return result;
    }

    /**
     * 递归算法
     */
    private void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursive(root.left, result);
            result.add(root.val);
            recursive(root.right, result);
        }
    }
}
