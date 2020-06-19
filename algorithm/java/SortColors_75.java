/**
 * 75. 颜色分类
 */
public class SortColors_75 {
    /**
     * 用三个指针（p0, p2 和 curr 来分别追踪 0 的最右边界，2 的最左边界和当前考虑的元素,
     * 沿着数组移动 curr 指针，若 nums[curr] = 0，则将其与 nums[p0]互换；
     * 若 nums[curr] = 2 ，则与 nums[p2]互换。
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            } else if (nums[cur] == 0 && cur != p0) {
                swap(nums, cur, p0);
                p0++;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
