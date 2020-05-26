/**
 * 69. x 的平方根
 */
class SqrtX_69 {
    /**
     * 二分查找
     */
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int l = 0, r = x;
        int mid = 0;
        int ans = mid;
        while (l <= r) {  // 这里的等号很关键，需要自己演推出来
            mid = (l + r) / 2;
            if (x >= (long) mid * mid) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrtMath(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        SqrtX_69 sqrtX = new SqrtX_69();
        System.out.println(sqrtX.mySqrt(1));
    }
}