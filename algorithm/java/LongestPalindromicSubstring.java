/**
 * 5. 最长回文子串
 */
class LongestPalindromicSubstring {
    /**
     * 循环遍历对每个以索引为 i 和 i，i + 1 为中心向前后扩展,
     * 存储最长回文子串的头尾索引
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isBlank()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] se1 = expandAroundCenter(s, i, i);
            int[] se2 = expandAroundCenter(s, i, i + 1);
            if (se1[1] - se1[0] - 1 > end - start) {
                start = se1[0] + 1;
                end = se1[1];
            }
            if (se2[1] - se2[0] - 1 > end - start) {
                start = se2[0] + 1;
                end = se2[1];
            }
        }
        return s.substring(start, end);
    }

    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left, right};
    }
}