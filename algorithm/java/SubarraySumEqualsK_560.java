import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
class SubarraySumEqualsK_560 {
    /**
     * 前缀和 + 哈希表优化
     * 我们定义 pre[i] 为 [0..i] 里所有数的和，
     * 则 pre[i] 可以由 pre[i−1] 递推而来，即：
     * pre[i] = pre[i - 1] + nums[i]，
     * 那么 [j...i] 这个子数组和为 k 这个条件我们可以转化为：
     * pre[i] − pre[j − 1] == k，
     * 简单移项可得符合条件的下标 j 需要满足：
     * pre[j − 1] == pre[i] − k。
     * 由于给的是整数数组，可能会有重复的 pre[i] 值，
     * 所以 哈希表以和为键，出现次数为对应的值。
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;
        int cnt = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);  // 这里需要累加的是 (pre - k) 之前出现的次数
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
