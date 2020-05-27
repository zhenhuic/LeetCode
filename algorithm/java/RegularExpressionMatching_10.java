/**
 * 10. 正则表达式匹配
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;
        int strIdx = 0, patIdx = 0;
        return matchCore(s, strIdx, p, patIdx);
    }

    private boolean matchCore(String s, int strIdx, String p, int patIdx) {
        if (strIdx == s.length() && patIdx == p.length()) return true;
        if (strIdx != s.length() && patIdx == p.length()) return false;

        if (patIdx + 1 < p.length() && p.charAt(patIdx + 1) == '*') {
            if (strIdx < s.length() && (s.charAt(strIdx) == p.charAt(patIdx) || p.charAt(patIdx) == '.')) {
                return matchCore(s, strIdx, p, patIdx + 2) ||
                        matchCore(s, strIdx + 1, p, patIdx) ||
                        matchCore(s, strIdx + 1, p, patIdx + 2);
            } else {
                return matchCore(s, strIdx, p, patIdx + 2);
            }
        }

        if (strIdx < s.length() && s.charAt(strIdx) == p.charAt(patIdx) || p.charAt(patIdx) == '.') {
            return matchCore(s, strIdx + 1, p, patIdx + 1);
        }
        return false;
    }
}
