import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
class LongestSubstringWithoutRepeatingCharacters_3 {
    /**
     * 用一个 HashMap 做滑动窗口，
     * 当一个 map 里已经存在当前字符且它的索引大于等于 start，
     * 就更新最大值和 start。
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                maxLen = Math.max(maxLen, i - start);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        maxLen = Math.max(maxLen, s.length() - start);
        return maxLen;
    }
}
