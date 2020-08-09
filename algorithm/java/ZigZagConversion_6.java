import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6. Z 字形变换
 */
class ZigZagConversion_6 {
    /**
     * 模拟 Z 字形顺序将字符按行存储，
     * 最后将各行拼接出结果字符串
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < Math.min(n, numRows); i++) {
            rows.add(new StringBuilder());
        }
        boolean goingDown = false;
        int idx = 0;
        for (char ch : s.toCharArray()) {
            rows.get(idx).append(ch);
            if (idx == 0 || idx == rows.size() - 1) {
                goingDown = !goingDown;
            }
            idx += goingDown ? 1 : -1;
        }
        StringBuilder ret = rows.get(0);
        for (int i = 1; i < rows.size(); i++) {
            ret.append(rows.get(i));
        }
        return ret.toString();
    }

    /**
     * 找出结果字符串每行字符在原字符串中索引的规律，
     * 这样就可以按结果的行输出。
     *
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
     * 对于所有整数 k，
     * 行 0 中的字符位于索引 k(2*numRows−2) 处;
     * 行 numRows−1 中的字符位于索引 k(2*numRows−2)+numRows−1 处;
     * 内部的行 i 中的字符位于索引 k(2*numRows−2)+i 以及 (k+1)(2*numRows−2)−i 处;
     */
    public String convertMath(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}