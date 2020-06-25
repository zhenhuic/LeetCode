/**
 * 200. 岛屿数量
 */
public class NumberOfIslands_200 {
    /**
     * 遍历每一个格子，遇到为 1 的格子计数器加 1，
     * 再深度优先遍历将相邻的格子改成 1
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int rowIdx, int colIdx) {
        grid[rowIdx][colIdx] = '0';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, -1, 0, 1};
        for (int i = 0; i < rowOffset.length; i++) {
            int ro = rowIdx + rowOffset[i];
            int co = colIdx + colOffset[i];
            if (ro >= 0 && ro < grid.length && co >= 0 && co < grid[0].length) {
                if (grid[ro][co] == '1') {
                    dfs(grid, ro, co);
                }
            }
        }
    }
}
