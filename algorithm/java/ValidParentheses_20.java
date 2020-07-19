import java.util.*;

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

    /**
     * 第二遍刷，用了 Map 映射左右括号
     */
    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int len = s.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } else {
                if (!stack.isEmpty() && map.get(stack.peekLast()) == c) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
