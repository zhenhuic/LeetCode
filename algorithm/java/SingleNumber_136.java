import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 */
class SingleNumber_136 {
    /**
     * 因为其余每个元素均出现两次
     * 使用异或运算
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        return Arrays.stream(nums).reduce((o1, o2) -> o1 ^ o2).getAsInt();
    }
}
