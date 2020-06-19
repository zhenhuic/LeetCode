import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsII_90 {
    /**
     * 主要是去重
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，
     * 让之前幂集中的每个集合，追加这个元素，就是新增的子集。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        Arrays.sort(nums);
        result.add(new ArrayList<>());
        int repeat = 0;
        for (int i = 0; i < nums.length; i++) {
            Iterator<List<Integer>> iter = result.iterator();
            List<List<Integer>> temp = new ArrayList<>();

            // 对重复的个数计数
            if (i > 0 && nums[i] == nums[i - 1]) repeat++;
            else repeat = 0;

            while (iter.hasNext()) {
                List<Integer> record = iter.next();
                List<Integer> li = new ArrayList<>(record);
                // 去重，只有不重复 或者 重复且已存在的重复个数等于 repeat 添加
                if (repeat > 0 && (record.size() < repeat ||
                        record.get(record.size() - repeat) != nums[i]))
                    continue;
                li.add(nums[i]);
                temp.add(li);
            }
            result.addAll(temp);
        }
        return result;
    }
}
