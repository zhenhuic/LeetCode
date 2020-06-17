/**
 * 53. 最大子序和
 */
public class MaximumSubarray_53 {
    /**
     * if (sum > 0) sum += n;
     * else sum = n;  // 累计和为负了，那就扔掉重新开始
     * max = Math.max(sum, max);
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) {
                sum += n;
            } else {
                sum = n;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
