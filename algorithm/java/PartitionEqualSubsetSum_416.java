import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class PartitionEqualSubsetSum_416 {
    /**
     * 就是求有没有数组的子集的和为 sum / 2，
     * 用二维动态规划，
     * 横轴表示前 i 个数，纵轴表示和。
     * 还可以将空间优化为一维数组
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        sum >>= 1;

        int len = nums.length;
        boolean [][] dp = new boolean[len + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] ||
                        (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[len][sum];
    }

    /**
     * 优化辅助空间为一维数组
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        sum >>= 1;

        int len = nums.length;
        boolean [] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            // 这里需要反向计算，因为如果正向的话，
            // 一维数组中这一次计算的数据会覆盖上一次的，
            // 这样后面如果用到上一次的数，其实是已经被改为当前次了
            for (int j = sum; j > 0; j--) {
                dp[j] = dp[j] || (j >= nums[i - 1] && dp[j - nums[i - 1]]);
            }
        }
        return dp[sum];
    }

    /**
     * 这题DFS是超出时间限制的
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        else sum = sum >> 1;

        Arrays.sort(nums);
        return dfs(nums, 0, sum);
    }

    private boolean dfs(int[] nums, int index, int sum) {
        if (sum == 0) return true;
        if (sum < 0) return false;

        for (int i = index; i < nums.length; i++) {
            if (dfs(nums, i + 1, sum - nums[i])) {
                return true;
            }
        }
        return false;
    }
}
