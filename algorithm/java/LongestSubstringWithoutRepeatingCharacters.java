import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 */
class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 用一个 HashSet 做滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightIndex < s.length() && !set.contains(s.charAt(rightIndex))) {
                set.add(s.charAt(rightIndex));
                rightIndex++;
            }
            if (set.size() > maxLen) maxLen = set.size();
        }
        return maxLen;
    }
}
