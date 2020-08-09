/**
 * 75. 颜色分类
 */
public class SortColors_75 {
    /**
     * 用三个指针（p0, p2 和 curr 来分别追踪 0 的最右边界，2 的最左边界和当前考虑的元素,
     * 沿着数组移动 curr 指针，若 nums[curr] = 0，则将其与 nums[p0]互换；
     * 若 nums[curr] = 2 ，则与 nums[p2]互换。
     *
     * 第三遍写交换逻辑还是有问题，
     * 其实不需要把这道题的解题思路想多复杂，
     * 就是三个指针，p0，p2，cur，
     * 当nums[cur]是0时，就和p0交换，p0和cur同时都自增1；
     * 当nums[cur]是2时，就和p2交换，这时只有p2自减1，cur不变；
     * 当nums[cur]是1时，cur自增1。
     */
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0++, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, p2--, cur);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
