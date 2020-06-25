/**
 * 152. 乘积最大子数组
 */
class MaximumProductSubarray_152 {
    /**
     * 动态规划
     * 状态转移方程:
     * f_max(i) = max(f_max(i - 1) * a_i, f_min(i - 1) * a_i, a_i)
     * f_min(i) = min(f_max(i - 1) * a_i, f_min(i - 1) * a_i, a_i)
     * 因为有正负，所以需要将最大最小值都保存下来
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 这里的临时变量是必要的，下面要用两次，所以不能在原来变量上改
            int mx = max, mn = min;
            min = Math.min(mx * nums[i], Math.min(mn * nums[i], nums[i]));
            max = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));

            res = Math.max(res, max);
        }
        return res;
    }
}