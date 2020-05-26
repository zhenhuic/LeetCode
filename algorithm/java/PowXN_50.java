/**
 * 50. Pow(x, n)
 */
class PowXN_50 {
    /**
     * 快速幂算法 + 递归
     */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        // 当 int 型 n 为 -2**31 (-2147483648) 时，
        // 不能直接取相反数，所以这里需要转成 long 型
        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    /**
     * 递归
     */
    private double quickMulRecursion(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickMulRecursion(x, n >> 1);
        return (n & 1) == 0 ? y * y : y * y * x;
    }

    /**
     * 迭代 牛
     */
    private double quickMul(double x, long n) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double xContribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= xContribute;
            }
            // 将贡献不断地平方
            xContribute *= xContribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return ans;
    }
}