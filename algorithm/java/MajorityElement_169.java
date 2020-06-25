/**
 * 169. 多数元素
 */
public class MajorityElement_169 {
    /**
     * 设置两个变量 candidate 和 count，
     * 遍历一遍数组，
     * 如果 count 为 0，将当前遍历的元素赋给 candidate；
     * 如果 count 不为 0 且 candidate 等于当前遍历的元素，将 count 加 1；
     * 如果 count 不为 0 且 candidate 不等于当前遍历的元素，那么将 count 减 1；
     * 最后结果就是 candidate。
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                ++count;
            } else {
                if (num == candidate) ++count;
                else --count;
            }
        }
        return candidate;
    }
}
