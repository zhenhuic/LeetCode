import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 */
class LongestSubstringWithoutRepeatingCharacters_3 {
    /**
     * 用一个 HashMap 做滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);  // 注意这里需要加 1
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
