/**
 * 494. 目标和
 */
public class TargetSum_494 {
    int count = 0;

    /**
     * 递归枚举
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        recurse(nums, 0, 0, S);
        return count;
    }

    private void recurse(int[] nums, int idx, int sum, int S) {
        if (idx == nums.length && sum == S) {
            count++;
        } else if (idx < nums.length) {
            recurse(nums, idx + 1, sum + nums[idx], S);
            recurse(nums, idx + 1, sum - nums[idx], S);
        }
    }

    /**
     * 动态规划
     * dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
     * 还可以用一个临时数组来优化空间
     */
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0 || S > 1000) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][1000 - nums[0]] += 1;  // 注意这里要自增，因为 num[0] 可能为 0

        for (int i = 1; i < len; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] > 0) {
                    dp[i][j + 1000 + nums[i]] += dp[i - 1][j + 1000];
                    dp[i][j + 1000 - nums[i]] += dp[i - 1][j + 1000];
                }
            }
        }
        return dp[len - 1][S + 1000];
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}
