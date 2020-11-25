/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class Problem14 {
    /**
     * 动态规划
     * 0 不是正整数，1 是最小的正整数，0 和 1 都不能拆分，因此 dp[0] = dp[1] = 0。
     * 当 i ≥ 2 时，假设对正整数 i 拆分出的第一个正整数是 j (1 ≤ j < i)，则有以下两种方案：
     *   将 i 拆分成 j 和 i - j 的和，且 i - j 不再拆分成多个正整数，此时的乘积是 j × (i − j)；
     *   将 i 拆分成 j 和 i − j 的和，且 i − j 继续拆分成多个正整数，此时的乘积是 j × dp[i − j]。
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
