import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal_144 {
    /**
     * 迭代
     * 1. 从根节点开始，每次迭代弹出当前栈顶元素，
     *    并将其孩子节点压入栈中，先压右孩子再压左孩子。
     * 2.
     * 栈S;
     * p= root;
     * while(p || S不空){
     *     while(p){
     *         访问p节点；
     *         p的右子树入S;
     *         p = p的左子树;
     *     }
     *     p = S栈顶弹出;
     * }
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 这部分和后序遍历很像，但注意区别
            output.add(node.val);
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
        }
        return output;
    }

    /**
     * 递归算法
     */
    private void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursive(root.left, result);
            recursive(root.right, result);
        }
    }
}
