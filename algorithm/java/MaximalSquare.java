/**
 * 221. 最大正方形
 */
public class MaximalSquare {
    /**
     * 动态规划
     * 用 dp[i][j] 表示以 (i, j) 为右下角的最大正方形的边长,
     * 如果该位置的值是 0，则 dp(i, j) = 0，因为当前位置不可能在由 1 组成的正方形中；
     * 如果该位置的值是 1，则 dp(i, j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
     * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1。
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        int rowNum = matrix.length, colNum = matrix[0].length;
        int[][] dp = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    if (dp[i][j] > maxSide) maxSide = dp[i][j];
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 动态规划的空间复杂度一般都可以进行降维处理，
     * 只是用到了上一层的 dp[i-1][j-1] 和上一层的 dp[i-1][j]，
     * 所以我们除了存储一行数据之外，
     * 只需要再找一个变量存一下 dp[i-1][j-1] 就好了，
     * dp[i-1][j]没必要存，因为更新之前它的值还是旧值。
     */
    public int maximalSquareOptimized(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        int rowNum = matrix.length, colNum = matrix[0].length;
        int[] dp = new int[colNum];
        int cross = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int temp = dp[j];
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), cross) + 1;
                    }
                    if (dp[j] > maxSide) maxSide = dp[j];
                } else {
                    dp[j] = 0;  // 注意这里需要赋 0
                }
                cross = temp;
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 求一个整数二进制序列中连续最多的 1（非本题用到）
     * 每次将这个数和它左移一位后的数相与，直到它变成 0，
     * 记录操作次数，这个操作次数就是连续最多的1。
     */
    private int getWidth(long num) {
        int w = 0;
        while (num > 0) {
            num &= (num << 1);
            w += 1;
        }
        return w;
    }
}
