import entity.TreeNode;

import java.util.HashMap;

/**
 * 337. 打家劫舍 III
 */
public class HouseRobberIII_337 {
    /**
     * 暴力递归，最优子结构
     * 走当前节点的最优解是
     * max(当前节点的钱 + 4个孙子节点的钱, 2个孩子节点的钱)
     *
     * 但是这会有很多重复计算的过程，
     * 当前节点会计算子节点和孙子节点的最优解，
     * 而进入到子节点又会重复计算一遍该子节点的子节点。
     *
     * 避免重复的方式有两种：
     * 1. 用一个记忆哈希表存储中间值；
     * 2. 把该问题抽象成只与子节点有关，
     * 不去涉及孙子节点，这样就能避免重复计算。
     * 具体的，任何一个节点能偷到的最大钱的状态可以定义为：
     * 1) 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 2) 当前节点选择偷：当前节点能偷到的最大钱数 =
     * 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    /**
     * 次优
     * 使用哈希表来存储结果，TreeNode 当做 key，能偷的钱当做 value
     */
    public int rob1(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;

        if (root.left != null) {
            money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
        }
        if (root.right != null) {
            money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
        }
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }

    /**
     * 最优
     * 递归返回该节点偷和不偷情况的最优解的数组，
     * 这样就避免了当前节点计算孙子节点的状态，
     * 从而避免了重复计算
     */
    public int rob2(TreeNode root) {
        int[] money = robCore(root);
        return Math.max(money[0], money[1]);
    }

    private int[] robCore(TreeNode root) {
        int[] money = new int[2];
        if (root == null) return money;

        int[] left = robCore(root.left);
        int[] right = robCore(root.right);
        // 注意，这里需要比较偷或者不偷的情况，因为可以选择偷或不偷
        // 当前家不偷，下一家也可以选择偷或不偷，下家不是一定要偷的
        money[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        money[1] = left[0] +right[0] + root.val;
        return money;
    }
}
