import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class ValidParentheses_20 {
    /**
     * 用栈
     * 注意括号的 ASCII 码值
     * ')' - '(' = 1;
     * ']' - '[' = 2;
     * '}' - '{' = 2.
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && (stack.peek() == ch - 1 || stack.peek() == ch - 2)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
