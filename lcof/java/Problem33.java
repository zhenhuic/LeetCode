import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Problem33 {
    /**
     * 单调栈
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     */
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peekLast() > postorder[i]) {
                root = stack.pollLast();
            }
            stack.addLast(postorder[i]);
        }
        return true;
    }
}
