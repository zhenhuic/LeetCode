/**
 * 9. 回文数
 */
class PalindromeNumber_9 {
    /**
     * 转成字符串，双指针比较；
     * 或者
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}