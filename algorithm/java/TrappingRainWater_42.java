/**
 * 42. 接雨水
 */
public class TrappingRainWater_42 {
    /**
     * 1. 双指针
     * 在前后端设置两个指针 l， r和 两个变量 leftMax，rightMax，
     * 比较左右两边哪边较小，那么就只要考虑较小一边的位置的盛水量，
     * 因为较大一边是肯定可以留住水的，
     * 较小的一边要么比它那边的最大值大，就表示这个位置盛不了水，那就更新这边的最大值，
     * 要么比这边的最大值小，那就可以计算这个位置的盛水量了。
     *
     * 如果 height[l] < height[r]：
     *   那么右端最大值不变，当前位置的盛水量依赖于 height[l] 和 leftMax 的大小，
     *   移动 l 指针；
     * 如果height[l] >= height[r]：
     *   那么左端最大值不变，当前位置的盛水量依赖于 height[r] 和 rightMax 的大小，
     *   移动 r 指针。
     *
     * 2. 用 leftMax[]，rightMax[] 两个数组存储每个位置的右端和左端最大高度，
     * 再计算每个位置的盛水量
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftMax = 0, rightMax = 0;
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > leftMax)
                    leftMax = height[l];
                else
                    ans += leftMax - height[l];
                l++;
            } else {
                if (height[r] > rightMax)
                    rightMax = height[r];
                else
                    ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
