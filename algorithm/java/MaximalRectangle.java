import java.util.Arrays;

/**
 * 85. 最大矩形
 * 困难
 */
class MaximalRectangle {
    /**
     * 动态规划
     * 从上到下，分别找到当前位置为底的矩形的最大高度和左右边界索引，
     * 矩形的高度和边界分别依赖上一行的矩形高度和边界。
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] left = new int[cols];  // initialize left as the leftmost boundary possible
        int[] right = new int[cols];
        int[] height = new int[cols];

        Arrays.fill(right, cols); // initialize right as the rightmost boundary possible

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            int cur_left = 0, cur_right = cols;
            // update height
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // update left
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = cols;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }
}