import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class ThreeSum_15 {
    /**
     * 排序 + 双指针法
     * 1. 特判，对于数组长度 nn，如果数组为 null 或者数组长度小于 3，返回 []；
     * 2. 对数组进行排序；
     * 3. 遍历排序后数组：
     * - 若 nums[i]>0，因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果；
     * - 对于重复元素：跳过，避免出现重复解；
     * - 令左指针 l=i+1，右指针 r=n−1，当 l<r 时，执行循环：
     *   - 当 nums[i]+nums[l]+nums[r]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解，
     *     并同时将 l,r 移到下一位置，寻找新的解；
     *   - 若和大于 0，说明 nums[r] 太大，r 左移；
     *   - 若和小于 0，说明 nums[l] 太小，l 右移。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        int len = nums.length;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--; // 去重
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }
}
