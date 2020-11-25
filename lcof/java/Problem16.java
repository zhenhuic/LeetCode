/**
 * 剑指 Offer 16. 数值的整数次方
 */
public class Problem16 {
    public double myPow(double x, int n) {
        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }

        double ans = 1.0;
        double p = x;
        while (nn > 0) {
            if ((nn & 1) == 1) {
                ans *= p;
            }
            p *= p;
            nn >>= 1;
        }
        return ans;
    }
}
