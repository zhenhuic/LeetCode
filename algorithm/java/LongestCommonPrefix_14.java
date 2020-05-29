/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix_14 {
    /**
     * easy
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    ch = '\n';
                    break;
                }
            }
            if (ch == '\n') {
                end = i;
                break;
            } else {
                end = i + 1;
            }
        }
        return strs[0].substring(0, end);
    }
}
