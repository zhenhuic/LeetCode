import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 */
public class DecodeString_394 {
    /**
     * 用两个栈保存数字和数字前的字符串，
     * 迭代遍历一遍
     * 不过用递归更快
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder res = new StringBuilder();

        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                strStack.addLast(res.toString());
                res = new StringBuilder();
                numStack.addLast(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                tmp.append(strStack.removeLast());
                int cnt = numStack.removeLast();
                for (int i = 0; i < cnt; i++) {
                    tmp.append(res);
                }
                res = tmp;
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * 整体思想与迭代相似，
     * 不过要注意递归回来后要跳出子括号，
     * 所以这里递归函数返回一个 String[]，
     * 第一个表示子序列结束索引，第二个表示子序列
     */
    public String decodeStringRecursive(String s) {
        return dfs(s, 0)[1];
    }

    private String[] dfs(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cnt = cnt * 10 + (c - '0');
            } else if (c == '[') {  // 递归处理括号内的序列
                String[] subs = dfs(s, i + 1);
                for (int j = 0; j < cnt; j++) {
                    sb.append(subs[1]);
                }
                cnt = 0;
                // 将返回回来的索引赋给 i，跳出子括号
                i = Integer.parseInt(subs[0]);
            } else if (c == ']') {  // 括号结束返回括号内的序列和索引值
                return new String[] {String.valueOf(i), sb.toString()};
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return new String[] {String.valueOf(0), sb.toString()};
    }
}
