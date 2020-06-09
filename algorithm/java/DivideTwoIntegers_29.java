/**
 * 29. 两数相除
 */
public class DivideTwoIntegers_29 {
    /**
     * 将除数翻倍与被除数比较，直到除数大于被除数，记录次数，
     * 再递归计算（被除数 - 翻倍后的除数）与原除数的商
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend != Integer.MIN_VALUE ? -dividend : Integer.MAX_VALUE;

        boolean sign;
        sign = (dividend >= 0 || divisor <= 0) && (dividend <= 0 || divisor >= 0);
        long dvd = dividend < 0 ? -(long) dividend : dividend;
        long dvs = divisor < 0 ? -(long) divisor : divisor;

        int ret = divideCore(dvd, dvs);
        return sign ? ret : -ret;
    }

    private int divideCore(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long dvs = divisor;
        int cnt = 1;
        while (dvs + dvs < dividend) {
            dvs += dvs;
            cnt += cnt;
        }
        int sub = divideCore(dividend - dvs, divisor);
        return cnt + sub;
    }

    public static void main(String[] args) {
        DivideTwoIntegers_29 p = new DivideTwoIntegers_29();
        System.out.println(p.divide(-2147483648, 2));
    }
}
