/**
 * 283. 移动零
 */
public class MoveZeroes_283 {
    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;

        int zeroIdx = 0;
        while (zeroIdx < len && nums[zeroIdx] != 0)
            zeroIdx++;
        if (zeroIdx == len) return;

        for (int i = zeroIdx + 1; i < len; i++) {
            if (nums[i] != 0) {
                nums[zeroIdx++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
