import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和
 */
public class FourSum_18 {
    /**
     * 同 三数之和、两数之和
     * 注意 一个重复利用的集合，避免在函数内部多次添加元素，应写成返回值的形式
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        findNSum(nums, 0, nums.length - 1, target, 4, result, results);
        return results;
    }

    private void findNSum(int[] nums, int l, int r, int target, int N,
                          List<Integer> result, List<List<Integer>> results) {  // 避免写这种重复利用的集合，在函数内部多次添加元素
        if (r - l + 1 < N || N < 2 || target < nums[l] * N || target > nums[r] * N)
            return;
        if (N == 2) {
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> newResult = new ArrayList<>(result);
                    newResult.add(nums[l]);
                    newResult.add(nums[r]);
                    results.add(newResult);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            for (int i = l; i < r + 1; i++) {
                if (i == l ||  nums[i - 1] != nums[i]) {
                    List<Integer> newResult = new ArrayList<>(result);
                    newResult.add(nums[i]);
                    findNSum(nums, i + 1, r, target - nums[i], N - 1, newResult, results);
                }
            }
        }
    }

    public static void main(String[] args) {
        FourSum_18 p = new FourSum_18();
        System.out.println(p.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
