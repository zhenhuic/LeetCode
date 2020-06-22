/**
 * 79. 单词搜索
 */
public class WordSearch_79 {
    /**
     * 递归回溯
     * 主要注意 回溯回来时恢复 used 状态
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0) return false;

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    boolean res = search(board, used, i, j, word, 1);
                    if (res) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] used, int row, int col, String word, int idx) {
        if (idx == word.length()) return true;

        if (row > 0 && !used[row - 1][col] &&
                board[row - 1][col] == word.charAt(idx)) {
            used[row - 1][col] = true;
            boolean res = search(board, used, row - 1, col, word, idx + 1);
            if (res) return true;
            used[row - 1][col] = false;
        }
        if (row < board.length - 1 && !used[row + 1][col] &&
                board[row + 1][col] == word.charAt(idx)) {
            used[row + 1][col] = true;
            boolean res = search(board, used, row + 1, col, word, idx + 1);
            if (res) return true;
            used[row + 1][col] = false;
        }
        if (col > 0 && !used[row][col - 1] &&
                board[row][col - 1] == word.charAt(idx)) {
            used[row][col - 1] = true;
            boolean res = search(board, used, row, col - 1, word, idx + 1);
            if (res) return true;
            used[row][col - 1] = false;
        }
        if (col < board[0].length - 1 && !used[row][col + 1] &&
                board[row][col + 1] == word.charAt(idx)) {
            used[row][col + 1] = true;
            boolean res = search(board, used, row, col + 1, word, idx + 1);
            if (res) return true;
            used[row][col + 1] = false;
        }
        return false;
    }
}
