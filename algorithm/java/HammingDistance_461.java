/**
 * 461. 汉明距离
 */
public class HammingDistance_461 {
    /**
     * 用异或（XOR），相同为 0，相异为 1，
     * 再计算出 1 的个数，
     * 对于任意数字 n ，将 n 和 n−1 做与运算，会把最后一个 1 的位变成 0
     */
    public int hammingDistance(int x, int y) {
        int d = x ^ y;
        int cnt = 0;
        while (d > 0) {
            d = d & (d - 1);
            cnt++;
        }
        return cnt;
    }
}
