import entity.TreeNode;

/**
 * 437. 路径总和 III
 */
public class PathSumIII_437 {
    /**
     * 递归
     * 需要注意如果路开始走了，那中间就不能停，
     * 如果还没开始走，那么可以选着走或者不走这个节点，
     * 所以用了一个标志位
     */
    public int pathSum(TreeNode root, int sum) {
        return pathSumCore(root, sum , false);
    }

    public int pathSumCore(TreeNode root, int sum, boolean started) {
        if (root == null) return 0;
        int paths = 0;
        // 需要在这里判断是否为 0，不应该传入下一个递归里判断，
        // 那样左右子树里都判断一次，照成重复
        if (sum - root.val == 0) paths++;
        if (!started) {
            paths += pathSumCore(root.left, sum, false) +
                    pathSumCore(root.right, sum, false);
        }
        paths += pathSumCore(root.left, sum - root.val, true) +
                pathSumCore(root.right, sum - root.val, true);
        return paths;

    }
}
