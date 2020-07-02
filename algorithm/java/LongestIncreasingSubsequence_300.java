/**
 * 300. 最长上升子序列
 */
public class LongestIncreasingSubsequence_300 {
    /**
     * 贪心算法 + 二分查找
     * 维护一个长度为 i 的上升子序列的最小尾部的值，
     * 因为尾部最小就更有可能接上后面更多的数字。
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
     */
    public int lengthOfLISGreedy (int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len <= 1) return len;

        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;  // end + 1表示最长子序列的长度

        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                // 二分查找，找到一个大于等于num[i]的数
                int l = 0, r = end;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (tail[mid] == nums[i]) {
                        l = mid;
                        break;
                    } else if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return end + 1;
    }

    /**
     * 动态规划
     * dp[i] = max(dp[j]) + 1, 其中 0 ≤ j < i 且 num[j] < num[i]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
