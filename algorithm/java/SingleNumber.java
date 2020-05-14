/**
 * 136. 只出现一次的数字
 */
class SingleNumber {
    /**
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
