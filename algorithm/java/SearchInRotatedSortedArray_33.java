/**
 * 33. 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray_33 {
    /**
     * 二分搜索
     * 有两种情况可能存在目标值：
     *   1. 正常的升序 nums[l] <= nums[r] && (nums[l] <= target && nums[r] >= target);
     *   2. 存在逆序 nums[l] > nums[r] && (nums[l] <= target || nums[r] >= target).
     */
    public int search(int[] nums, int target) {
        return searchCore(nums, 0, nums.length - 1, target);
    }

    private int searchCore(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        if (l == r) {
            if (nums[l] == target) return l;
            else return -1;
        }

        int mid = (l + r) >> 1;
        int lRet = -1, rRet = -1;
        if ((nums[l] <= nums[mid] && (nums[l] <= target && nums[mid] >= target)) ||
                (nums[l] > nums[mid] && (nums[l] <= target || nums[mid] >= target))) {
            lRet = searchCore(nums, l, mid, target);
        }
        if((nums[mid + 1] <= nums[r] && (nums[mid + 1] <= target && nums[r] >= target)) ||
                (nums[mid + 1] > nums[r] && (nums[mid + 1] <= target || nums[r] >= target))) {
            rRet = searchCore(nums, mid + 1, r, target);
        }
        return lRet != -1 ? lRet : rRet;
    }
}
