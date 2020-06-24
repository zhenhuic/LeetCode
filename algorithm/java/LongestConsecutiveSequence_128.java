import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 */
public class LongestConsecutiveSequence_128 {
    /**
     * 序列中存在重复的数字，
     * 所以用 Set 去重，
     * 遍历 Set，如果存在比它小 1 的值就跳过，
     * 如果不存在则计算以当前数字为最小的序列的最大长度。
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {  // 如果不存在比它小 1 的数
                int cnt = 1;
                // 计算以 num 为最小数的序列的最大长度
                while (numSet.contains(++num)) {
                    cnt++;
                }
                maxLen = Math.max(cnt, maxLen);
            }
        }
        return maxLen;
    }
}
