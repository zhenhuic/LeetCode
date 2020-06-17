import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class UniquePaths_62 {
    /**
     * 写烂的动态规划
     * 用一维数组优化
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] pathCnt = new int[n];
        Arrays.fill(pathCnt, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathCnt[j] = pathCnt[j - 1] + pathCnt[j];
            }
        }
        return pathCnt[n - 1];
    }
}
