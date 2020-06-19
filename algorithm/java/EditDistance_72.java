/**
 * 72. 编辑距离
 */
public class EditDistance_72 {
    /**
     * 动态规划，二维
     * 本质不同的操作实际上只有三种：
     *   在单词 A 中插入一个字符；
     *   在单词 B 中插入一个字符；
     *   修改单词 A 的一个字符。
     * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++)
            dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i < len2 + 1; i++)
            dp[0][i] = dp[0][i - 1] + 1;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 +1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(leftDown, Math.min(down, left));
            }
        }
        return dp[len1][len2];
    }
}
