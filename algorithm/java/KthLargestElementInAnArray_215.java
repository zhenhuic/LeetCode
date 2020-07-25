import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 */
public class KthLargestElementInAnArray_215 {
    /**
     * 基于快速排序的选择方法
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + new Random(System.currentTimeMillis()).nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];

        int l = left + 1, r = right;
        while (true) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l > r) break;
            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, r, left);
        return r;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
