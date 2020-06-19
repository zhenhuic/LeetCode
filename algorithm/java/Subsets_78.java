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
}
