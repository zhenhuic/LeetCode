/**
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Problem03 {
    /**
     * 朴素的方法是用一个辅助set保存，遍历一次。
     *
     * 高级的解法：
     *   题目限定数组中的数字是 0~n-1 的，
     *   所以每次将数字替换到对应的位置，使 nums[i] == i，
     *   过程中就可以找到相同的数字。
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
