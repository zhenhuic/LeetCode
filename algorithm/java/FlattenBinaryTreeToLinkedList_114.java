import entity.TreeNode;

/**
 * 114. 二叉树展开为链表
 */
public class FlattenBinaryTreeToLinkedList_114 {
    /**
     * 右子树先遍历的后序遍历，
     * 先遍历到的就是链表的最后一个节点，
     * 用一个全局变量保存这个节点，
     * 供下一个遍历的节点设置为左孩子，
     * 注意需要将右孩子设为 null。
     */
    // 代表当前节点在链表中的下一个节点
    TreeNode next = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }
}
