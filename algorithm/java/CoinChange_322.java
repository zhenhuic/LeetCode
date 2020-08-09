import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class CoinChange_322 {
    /**
     * 这题贪心算法不行！不行！！
     * 那是因为
     *
     * 动态规划
     * 定义 F(i) 为组成金额 i 所需最少的硬币数量，
     * 假设在计算 F(i) 之前，
     * 我们已经计算出 F(0)-F(i-1) 的答案。
     * c_j代表的是第 j 枚硬币的面值。
     * 则 F(i) 对应的转移方程应为
     * F(i)= min_(j=0...n-1) F(i - c_j) + 1
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
}
