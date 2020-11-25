/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class Problem62 {
    /**
     * 一个逆推的思路
     * 旧编号： 0    1    2 ... m-1  m  m+1  ...  n-1
     * 新编号：-m -m+1 -m+2 ... m-1  0    1  ...
     */
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
