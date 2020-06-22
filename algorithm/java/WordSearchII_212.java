import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 212. 单词搜索 II
 */
public class WordSearchII_212 {
    /**
     * 前缀树回溯
     * 将需要搜索的单词构造成一个前缀树，
     * 然后递归回溯
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return result;

        // 构建前缀树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode child = new TrieNode();
                    node.children.put(letter, child);
                    node = child;
                }
            }
            node.word = word;
        }

        int rowNum = board.length, colNum = board[0].length;
        boolean[][] used = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrack(board, used, i, j, root, result);
                }
            }
        }
        return result;
    }

    private void backtrack(char[][] board, boolean[][] used, int row, int col,
                           TrieNode parent, List<String> result) {
        Character letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // 因为外面判断过 parent.children.containsKey(letter)，
        // 所以这里 currNode 一定不为 null
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        used[row][col] = true;

        // 搜索周围4个方向: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            // 超出边界或使用过就跳过
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length || used[newRow][newCol]) {
                continue;
            }
            // 如果字母存在于 children map 里
            if (currNode.children.containsKey(board[newRow][newCol])) {
                backtrack(board, used, newRow, newCol, currNode, result);
            }
        }
        // 恢复状态
        used[row][col] = false;
    }
}

/**
 * 前缀树
 * 如果前缀加上当前节点的 key 能构成单词，
 * 则属性 word 为那个单词，否则为 null。
 */
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode() {};
}
