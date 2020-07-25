/**
 * 279. 完全平方数
 */
public class PerfectSquares_279 {
    /**
     * 动态规划，数组的代表能构成该索引数字的完全平方数的最小个数
     */
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
