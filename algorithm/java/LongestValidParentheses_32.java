import java.util.Stack;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses_32 {
    /**
     * 左右两次遍历
     *
     * 在这种方法中，我们利用两个计数器 left 和 right 。
     * 首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，
     * 我们增加 left 计算器，对于遇到的每个 ‘)’ ，
     * 我们增加 right 计数器。每当 left 计数器与 right 计数器相等时，
     * 我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
     * 如果 right 计数器比 left 计数器大时，
     * 我们将 left 和 right 计数器同时变回 0。
     * 接下来，我们从右到左做一遍类似的工作。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int lNum = 0, rNum = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lNum++;
            } else if (c == ')') {
                rNum++;
            }
            if (rNum > lNum) lNum = rNum = 0;
            if (rNum != 0 && rNum == lNum) {
                max = Math.max(max, rNum + lNum);
            }
        }
        lNum = 0; rNum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                lNum++;
            } else if (c == ')') {
                rNum++;
            }
            if (rNum < lNum) lNum = rNum = 0;
            if (rNum != 0 && rNum == lNum) {
                max = Math.max(max, rNum + lNum);
            }
        }
        return max;
    }

    /**
     * 栈
     *
     * 与找到每个可能的子字符串后再判断它的有效性不同，
     * 我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，
     * 同时能的都最长有效字符串的长度。我们首先将 -1−1 放入栈顶。
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
     * 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，
     * 得出当前有效括号字符串的长度。通过这种方法，我们继续计算有效子字符串的长度，
     * 并最终返回最长有效子字符串的长度。
     */
    public int longestValidParenthesesStack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
