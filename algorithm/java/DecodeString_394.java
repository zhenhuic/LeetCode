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
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                // 将返回回来的索引赋给 i，跳出子括号
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString()};
            else
                res.append(s.charAt(i));
            i++;
        }
        return new String[] { res.toString() };
    }
}
