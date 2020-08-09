import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *
 * 后序遍历就是先右后左的前序遍历的倒转
 */
public class BinaryTreePostorderTraversal_145 {
    /**
     * 迭代遍历
     * 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，
     * 然后依次压入它的所有孩子节点，
     * 按照从上到下、从左至右的顺序依次压入栈中。
     * 因为深度优先搜索后序遍历的顺序是从下到上、从左至右，
     * 所以需要将输出列表逆序输出。
     * 所以下面结果用的是 LinkedList 的头插
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.addFirst(cur.val);
                stack.addLast(cur);
                cur = cur.right;
            }
            cur = stack.pollLast().left;
        }
        return result;
    }

    /**
     * 递归
     */
    private void recursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursive(root.left, result);
            recursive(root.right, result);
            result.add(root.val);
        }
    }
}
