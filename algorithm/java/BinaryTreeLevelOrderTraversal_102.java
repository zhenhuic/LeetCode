import entity.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 */
class BinaryTreeLevelOrderTraversal_102 {
    /**
     * 用一个队列就行
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0;i < len; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);  
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }
}
