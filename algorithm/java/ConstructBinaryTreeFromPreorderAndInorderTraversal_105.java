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

    /**
     * 先算出左右子树节点个数
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeCore1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeCore1(int[] preorder, int preLeft, int preRight,
                                    int[] inorder, int inLeft, int inRight,
                                    Map<Integer, Integer> inorderMap) {
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) return root;

        int rootInIdx = inorderMap.get(preorder[preLeft]);
        int leftChildNum = rootInIdx - inLeft;
        int rightChildNum = inRight - rootInIdx;

        if (leftChildNum > 0) {
            root.left = buildTreeCore(preorder, preLeft + 1, preLeft + leftChildNum,
                    inorder, inLeft, rootInIdx - 1, inorderMap);
        }
        if (rightChildNum > 0) {
            root.right = buildTreeCore(preorder, preRight - rightChildNum + 1, preRight,
                    inorder, rootInIdx + 1, inRight, inorderMap);
        }
        return root;
    }
}
