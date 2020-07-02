/**
 * 240. 搜索二维矩阵 II
 */
public class SearchA2DMatrixII_240 {
    /**
     * 从矩阵的左下角开始向右和向上查找，
     * 当前元素正上方的数都是比它小的，正右方的数都是比它大的。
     * 如果目标值大于当前数，那么 col++，
     * 如果目标值小于当前数，那么 row--，直到找到目标值；
     * 如果 row 或 col 超出边界，那么退出，返回 false。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rowLen = matrix.length, colLen = matrix[0].length;
        int row = rowLen - 1, col = 0;
        while (row >= 0 && col < colLen) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
