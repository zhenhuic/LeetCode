/**
 * 10. 正则表达式匹配
 */
class RegularExpressionMatching_10 {
    /**
     * 动态规划
     * 视频讲解 https://www.bilibili.com/video/BV1Tt4y1U7QP
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        // memo[i][j] 代表 s[0..i] 与 p[0..j] 的匹配状态
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[0][0] = true;

        // 初始化当 s 为空字符串时，memo[0][0..p.length()] 的匹配状态
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && memo[0][i - 1]) {
                memo[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    memo[i + 1][j + 1] = memo[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        memo[i + 1][j + 1] = memo[i + 1][j - 1];  // 表示 * 前面的字符出现 0 次
                    } else {
                        // 这里需要去看图表理解
                        memo[i + 1][j + 1] = memo[i][j + 1] || memo[i + 1][j] || memo[i + 1][j - 1];
                    }
                }
            }
        }
        return memo[s.length()][p.length()];
    }
}
