/**
 * 7. 整数反转
 */
class ReverseInteger_7 {
    /**
     * 弹出和推入数字 & 溢出前进行检查
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 学会下面的溢出检查
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverseToString(int x) {
        long n = x;
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }
        String src = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = src.length() - 1; i >= 0; i--) {
            sb.append(src.charAt(i));
        }
        long ret = Long.parseLong(sb.toString());
        if (negative) ret = -ret;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
        return (int) ret;
    }

    public static void main(String[] args) {
        System.out.println(ReverseInteger_7.reverseToString(-2147483648));
    }
}