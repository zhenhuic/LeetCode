/**
 * 647. 回文子串
 */
public class PalindromicSubstrings_647 {
    /**
     * 暴力求解，对以每个字符为开始判断所有子串。
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (judge(s, i, j)) cnt++;
            }
        }
        return cnt;
    }

    private boolean judge(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划
     * 二维布尔数组 dp[i][j] 表示：
     * 字符串 s[i⋯j]是否为回文子串，
     * 如果是，dp[i][j] = true，
     * 如果不是，dp[i][j] = false。
     *
     * 如果 s[i] == s[j]，结果就依赖于 dp[i + 1][j - 1]，
     * 如果 s[i] != s[j]，那么说明 dp[i][j] 不是回文子串。
     */
    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int count = len;

        // 这里要从反方向求，因为 i 表示子串的起点索引，
        // 状态转移的时候需要依赖左右两边收缩一步的子串状态，
        // 如果是 i 从 0 开始，那么收缩一步的子串的状态就还没求过，
        // 所以一定要从 len - 2 反方向求解，这样收缩一步的子串的值就是都计算过的。
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}
