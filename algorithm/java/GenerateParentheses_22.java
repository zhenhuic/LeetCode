import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParentheses_22 {
    /**
     * 递归回溯法
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generate(List<String> result, StringBuilder sb, int open, int close, int max) {
        if (open == max && close == max) {
            result.add(sb.toString());
            return;
        }
        if (open < max) {  // 如果左括号的个数还没有达到最大值，可任意添加左括号
            sb.append("(");
            generate(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);  // 删除添加的左括号
        }
        if (close < open && close < max) {  // 如果现有的右括号的个数小于左括号和最大值，才可以添加右括号
            sb.append(")");
            generate(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);  // 删除添加的右括号
        }
    }
}
