import java.util.*;

/**
 * 39. 组合总和
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residuum    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates, int len, int residuum, int begin,
                     Deque<Integer> path, List<List<Integer>> res) {
        if (residuum == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 在数组有序的前提下，剪枝
            if (residuum - candidates[i] < 0) break;

            path.addLast(candidates[i]);
            dfs(candidates, len, residuum - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 p = new CombinationSum_39();
        System.out.println(p.combinationSum(new int[]{2,3,5}, 8));
    }
}
