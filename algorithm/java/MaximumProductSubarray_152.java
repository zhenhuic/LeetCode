/**
 * 152. 乘积最大子数组
 */
class MaximumProductSubarray_152 {
    /**
     * 动态规划
     * 状态转移方程:
     * f_max(i) = max(f_max(i - 1) * a_i, f_min(i - 1) * a_i, a_i)
     * f_min(i) = min(f_max(i - 1) * a_i, f_min(i - 1) * a_i, a_i)
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {  // 当为负数时，交换 imax 和 imin
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(imax, max);
        }
        return max;
    }
}