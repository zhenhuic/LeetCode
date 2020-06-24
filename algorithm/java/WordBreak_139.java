import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak_139 {
    /**
     * 动态规划
     * dp 数组表示以当前 i 索引为止的字符串能不能拆分为单词
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> wordDictSet=new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
