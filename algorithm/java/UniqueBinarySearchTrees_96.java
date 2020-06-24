/**
 * 96. 不同的二叉搜索树
 */
public class UniqueBinarySearchTrees_96 {
    /**
     * 遍历每个数字 i，将该数字作为树根，
     * 1 ... (i-1) 序列将成为左子树，(i+1) ... n 序列将成为右子树。
     * 于是，我们可以递归地从子序列构建子树。
     * 在上述方法中，由于根各自不同，每棵二叉树都保证是独特的。
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) { // 以每个数为根节点
                // 因为左右两边的树有不同，就代表整个树都是独特的，所以这里左右两边的个数是相乘
                // 因为要以一个每个节点作为根节点计算个数，所以这里是累加
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 递归
     * 相当于分而治之
     * 结果等于左右子树个数的乘积
     */
    public int numTreesRecur(int n) {
        return recursive(1, n);
    }

    private int recursive(int l, int r) {
        if (l >= r) return 1;
        if (r - l == 1) return 2;
        if (r - l == 2) return 5;

        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += recursive(l, i - 1) * recursive(i + 1, r);
        }
        return sum;
    }
}
