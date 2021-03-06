/**
 * 5. 最长回文子串
 */
class LongestPalindromicSubstring_5 {
    /**
     * 循环遍历对每个以索引为 i 和 i，i + 1 为中心向前后扩展,
     * 存储最长回文子串的头尾索引
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
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

    /**
     * 动态规划，第二遍写
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 1;
        int left = 0, right = 1;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i;
                    left = i;
                    right = j + 1;
                }
            }
        }
        return s.substring(left, right);
    }
}