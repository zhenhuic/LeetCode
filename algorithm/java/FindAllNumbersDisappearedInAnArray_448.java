import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class FindAllNumbersDisappearedInAnArray_448 {
    /**
     * 用原来的数组做标记，
     * 以出现过的数字为索引上的数字置为相反数
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = (nums[i] > 0 ? nums[i] : -nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
