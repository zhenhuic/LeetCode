/**
 * 剑指 Offer 65. 不用加减乘除做加法
 */
public class Problem65 {
    /**
     * 主要就是利用位运算，计算进位以及非进位和。
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;  // 进位
            a ^= b;  // 非进位和
            b = c;
        }
        return a;
    }
}
