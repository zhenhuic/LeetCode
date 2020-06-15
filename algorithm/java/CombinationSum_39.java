import java.util.*;

/**
 * 39. 组合总和
 */
public class CombinationSum_39 {
    /**
     * 动态规划
     * 注意去重
     * 在搜索的时候，需要设置搜索起点的下标 begin ，由于一个数可以使用多次，下一层的结点从这个搜索起点开始搜索；
     * 在搜索起点 begin 之前的数因为以前的分支搜索过了，所以一定会产生重复。
     */
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
