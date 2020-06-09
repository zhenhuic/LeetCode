import java.util.HashMap;
import java.util.Map;

/**
 * 28. 实现 strStr()
 */
public class ImplementStrStr_28 {
    /**
     * Sunday 算法
     * https://leetcode-cn.com/problems/implement-strstr/solution/python3-sundayjie-fa-9996-by-tes/
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        Map<Character, Integer> offset = calcOffset(needle);
        int hLen = haystack.length(), nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; ) {
            boolean matched = true;
            for (int j = 0; j < nLen; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return i;
            } else if (i + nLen + 1 < hLen) {
                Integer off = offset.get(haystack.charAt(i + nLen));
                if (off != null) {
                    i += off;
                } else {
                    i += nLen + 1;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private Map<Character, Integer> calcOffset(String pattern) {
        Map<Character, Integer> offset = new HashMap<>();
        int len = pattern.length();
        if (len == 0) return offset;
        for (int i = 0; i < len; i++) {
            offset.put(pattern.charAt(i), len - i);
        }
        return offset;
    }
}
