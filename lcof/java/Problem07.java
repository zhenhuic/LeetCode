import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class Problem07 {
    /**
     * 主要就是要想到利用用map查找根节点在inorder序列中的位置。
     */
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recur(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recur(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode node = new TreeNode(po[preLeft]);
        int rootIdx = inorderMap.get(po[preLeft]);
        node.left = recur(preLeft + 1, preLeft + rootIdx - inLeft, inLeft, rootIdx - 1);
        node.right = recur(preLeft + rootIdx - inLeft + 1, preRight, rootIdx + 1, inRight);
        return node;
    }
}
