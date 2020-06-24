import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    /**
     * 根据前序遍历的第一个节点去切分中序遍历的节点，
     * 用 Map 存储中序遍历的节点和索引，
     * 加快中序遍历中根节点位置的查询
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeCore(int[] preorder, int pl, int pr,
                                   int[] inorder, int il, int ir,
                                   Map<Integer, Integer> inorderMap) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int idx = inorderMap.get(root.val);

        root.left = buildTreeCore(preorder, pl + 1, pl + idx - il,
                inorder, il, idx - 1, inorderMap);
        root.right = buildTreeCore(preorder, pl + idx - il + 1,
                pr, inorder, idx + 1, ir, inorderMap);
        return root;
    }
}
