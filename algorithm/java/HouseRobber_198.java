/**
 * 198. 打家劫舍
 */
public class HouseRobber_198 {
    /**
     * 动态规划
     * 走到当前一家时，偷到的最大金额有两种情况：
     * 1. 前一家的不偷，金额就是前前一家偷的加上当前一家的金额；
     * 2. 当前一家的不偷，金额就是前一家的金额
     * 两种情况取最大值。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], n1 = 0, n2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(n1 + nums[i], n2);
            max = Math.max(tmp, max);
            n1 = n2;
            n2 = tmp;
        }
        return max;
    }
}
