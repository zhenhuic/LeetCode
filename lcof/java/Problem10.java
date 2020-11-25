/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Problem10 {
    /**
     * f(n)=f(n−1)+f(n−2)
     */
    public int numWays(int n) {
        int p = 0, q = 1, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return q;
    }
}
