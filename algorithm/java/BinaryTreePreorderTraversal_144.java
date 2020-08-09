import entity.TreeNode;

import java.util.ArrayList;
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
     *
     * 8.2 更精简的写法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast().right;
        }
        return result;
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
