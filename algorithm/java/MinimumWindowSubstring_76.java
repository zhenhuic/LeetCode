import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring_76 {
    /**
     * 滑动窗口/双指针
     * 先将窗口的右侧向右扩展窗口，如果满足了，
     * 再将窗口的左侧向右收缩窗口，看能不能继续满足，
     * 如果不满足了，则再将窗口右侧向右扩展窗口；
     *
     * 验证包不包含 T 所有字符，
     * 这里是维护一个 valid 变量，
     * 当 T 的某个字符的个数等于窗口内字符的个数，
     * 则 valid++，
     * 当 valid 等于 T 的 map 的大小，表示满足。
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int sLen = s.length(), tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, valid = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < sLen) {
            char ch = s.charAt(r);  // ch 是将移入窗口的字符
            r++;  // 右移窗口
            if (need.containsKey(ch)) {  // 进行窗口内数据的一系列更新
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (need.get(ch).equals(window.get(ch))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                char delChar = s.charAt(l);  // 将要移出窗口的字符
                l++;  // 左移窗口
                if (need.containsKey(delChar)) {  // 如果这个字符在窗口中
                    if (window.get(delChar).equals(need.get(delChar))) {
                        valid--;  // 原来是相等的话，移出一个就不满足了
                    }
                    window.put(delChar, window.get(delChar) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);  // substring() 参数是前后的索引
    }
}
