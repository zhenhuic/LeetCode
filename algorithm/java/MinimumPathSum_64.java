/**
 * 64. 最小路径和
 */
public class MinimumPathSum_64 {
    /**
     * 写烂的动态规划，一维数组存储中间过程
     * 如果可以修改原数组，那么在原数组上记录路径和，就不用额外空间了
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[] pathSum = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    pathSum[j] = grid[i][j];
                } else if (i == 0) {
                    pathSum[j] = pathSum[j - 1] + grid[i][j];
                } else if (j == 0) {
                    pathSum[j] = pathSum[j] + grid[i][j];
                } else {
                    pathSum[j] = Math.min(pathSum[j - 1], pathSum[j]) + grid[i][j];
                }
            }
        }
        return pathSum[pathSum.length - 1];
    }
}
