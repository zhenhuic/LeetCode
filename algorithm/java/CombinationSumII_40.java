import java.util.*;

/**
 * 40. 组合总和 II
 */
public class CombinationSumII_40 {
    /**
     * 以 target 为根结点，依次减去数组中的数字，
     * 直到小于 0 或者等于 0，把等于 0 的结果记录到结果集中。
     *
     * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target == 0) return res;

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(candidates.length);
        dfs(candidates, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int residuum,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (residuum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (residuum < candidates[begin]) {
                break;
            }
            // 这里去重，如果当前这个数是跟前面重复的，那么就会和上一次循环重复；
            // 但是 i == begin 是可以加进去的，是因为可以跟路径中上一步重复，
            // 而不是当前循环内（路径上同一个索引）
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, i + 1, residuum - candidates[i], path, res);
            path.removeLast();
        }
    }
}
