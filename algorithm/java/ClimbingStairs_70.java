/**
 * 70. 爬楼梯
 */
public class ClimbingStairs_70 {
    /**
     * 动态规划
     * 因为一次只能爬 1 或 2 个台阶，
     * 所以只需要存储前两次的结果。
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int a = 0, b = 0, c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public int climbStairs1(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
