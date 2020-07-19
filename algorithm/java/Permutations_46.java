import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. 全排列
 */
public class Permutations_46 {
    /**
     * 递归回溯
     * 用一个 set 记录用过的数的索引
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int len = nums.length;
        List<Integer> path = new ArrayList<>(len);
        Set<Integer> used = new HashSet<>(len);
        permuteCore(nums, used, path, result);
        return result;
    }

    private void permuteCore(int[] nums, Set<Integer> used, List<Integer> path,
                             List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {  // 将没有用过的一个数字放入路径中
                used.add(i);
                path.add(nums[i]);
                permuteCore(nums, used, path, result);

                // 回溯，就是恢复原来状态
                used.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 第二遍写，不用 Set，这样更快
     */
    public List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permuteCore(nums, used, path, result);
        return result;
    }

    private void permuteCore(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                permuteCore(nums, used, path, result);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
