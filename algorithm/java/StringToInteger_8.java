/**
 * 8. 字符串转换整数 (atoi)
 */
class StringToInteger_8 {
    /**
     * 注意判断数字越界技巧
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.isBlank())
            return 0;
        int start = 0;
        while (str.charAt(start) == ' ') start++;
        boolean negative = false;
        if (str.charAt(start) == '-') {
            negative = true;
            start++;
        } else if (str.charAt(start) == '+') {
            start++;
        }
        if (start >= str.length() || str.charAt(start) < '0' || str.charAt(start) > '9')
            return 0;
        int idx = start;
        int num = 0;
        while (idx < str.length() && (str.charAt(idx) >= '0' && str.charAt(idx) <= '9')) {
            int n = str.charAt(idx) - 48;
            if (!negative && (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && n > 7))
                return Integer.MAX_VALUE;
            if (negative && (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && n > 8))
                return Integer.MIN_VALUE;
            if (idx != start) {
                num = num * 10 + (negative? -n : n);
            } else {
                num = negative ? -n : n;
            }
            idx++;
        }
        return num;
    }
}