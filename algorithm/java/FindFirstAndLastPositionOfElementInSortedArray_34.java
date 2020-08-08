/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    /**
     * 就是两次二分查找，
     * 注意边界条件和可能会导致死循环的地方
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int len = nums.length;
        int l = 0, r = len - 1;
        int tl = -1;
        // 找左边界，细分出三种情况
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            tl = l;
        }
        if (tl == -1) return new int[]{-1, -1};

        l = 0;
        r = len - 1;
        // 找右边界
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                // 下面的细分是为了防止死循环
                if (nums[mid + 1] == target) {
                    l = mid + 1;
                } else {
                    r = mid;
                    break;
                }
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] == target) {
            return new int[]{tl, r};
        }
        return new int[]{-1, -1};
    }

    public int[] searchRange1(int[] nums, int target) {
        int left = searchLeft(nums, 0, nums.length - 1, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = searchRight(nums, 0, nums.length - 1, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
        } else if (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                return searchLeft(nums, left, mid, target);
            } else {
                return searchLeft(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    private int searchRight(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
        } else if (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                return searchRight(nums, mid + 1, right, target);
            } else if (nums[mid] == target) {
                if (mid + 1 <= right && nums[mid + 1] == target) {
                    return searchRight(nums, mid + 1, right, target);
                } else {
                    return mid;
                }
            } else {
                return searchRight(nums, left, mid, target);
            }
        }
        return -1;
    }
}
