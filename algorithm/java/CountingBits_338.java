/**
 * 338. 比特位计数
 */
public class CountingBits_338 {
    /**
     * 动态规划
     * 每次通过位运算将二进制的最后一个 1 的位变成 0，
     * 再从数组中找到这个数的 1 的个数 + 1
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            // 对于任意数字 n ，将 n 和 n−1 做与运算，会把最后一个 1 的位变成 0
            res[i] = res[i & i - 1] + 1;
        }
        return res;
    }
}
