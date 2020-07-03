import entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree_297 {
}

/**
 * 先序遍历 或者 深度遍历
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        // 这里用链表，提高后面 remove() 的性能
        List<String> strList = new LinkedList<>(Arrays.asList(strs));
        return preorderDeserialize(strList);
    }

    private void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            sb.append(",");
            preorderSerialize(root.left, sb);
            preorderSerialize(root.right, sb);
        } else {
            sb.append("#,");
        }
    }

    private TreeNode preorderDeserialize(List<String> strList) {
        if (strList.get(0).equals("#")) {
            strList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strList.get(0)));
        strList.remove(0);
        root.left = preorderDeserialize(strList);
        root.right = preorderDeserialize(strList);
        return root;
    }
}
