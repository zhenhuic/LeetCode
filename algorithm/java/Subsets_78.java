import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets_78 {
    /**
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，
     * 让之前幂集中的每个集合，追加这个元素，就是新增的子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        result.add(new ArrayList<>());
        for (int n : nums) {
            Iterator<List<Integer>> iter = result.iterator();  // 注意 Iterator 的泛型
            List<List<Integer>> temp = new ArrayList<>();
            while (iter.hasNext()) {
                List<Integer> li = new ArrayList<>(iter.next());
                li.add(n);
                temp.add(li);
            }
            result.addAll(temp);
        }
        return result;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> prefix = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrack(nums, 0, prefix, result);
        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> prefix,
                           List<List<Integer>> result) {
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            prefix.add(nums[i]);
            result.add(new ArrayList<>(prefix));
            backtrack(nums, i + 1, prefix, result);
            prefix.remove(prefix.size() - 1);
        }
    }
}
