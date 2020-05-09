/**
 * 69. x 的平方根
 */
class SqrtX {
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

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(1));
    }
}