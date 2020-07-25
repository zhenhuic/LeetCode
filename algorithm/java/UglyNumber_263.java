/**
 * 263. 丑数
 */
public class UglyNumber_263 {
    /**
     * Second Kill
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num != 1) {
            boolean divide = false;
            if (num % 2 == 0) {
                num /= 2;
                divide = true;
            }
            if (num % 3 == 0) {
                num /= 3;
                divide = true;
            }
            if (num % 5 == 0) {
                num /= 5;
                divide = true;
            }
            if (!divide) return false;
        }
        return true;
    }
}
