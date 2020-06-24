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
}
