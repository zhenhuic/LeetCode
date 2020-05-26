import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum_1 {
    /**
     * 利用 Map 快速找到 target - nums[i] 值对应的索引
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(target - n)) {
                return new int[]{map.get(target - n), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
