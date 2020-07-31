import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAllAnagramsInAString_438 {
    /**
     * 滑动窗口，
     * 移动右窗口将字符添加进滑动窗口，
     * 当刚添加进的字符不在需要的字符串里或个数大于需要的字符串中该字符的个数时，
     * 移动做窗口收缩窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int[] window = new int[26];  // 滑动窗口
        int[] needs = new int[26];  // 需要的各个字符的个数

        for (char c : pChars) {
            needs[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();

        int l = 0, r = 0;
        // 移动右指针，将所指字符添加到滑动窗口
        while (r < sChars.length) {
            int chIdx = sChars[r] - 'a';
            window[chIdx]++;
            r++;
            // 当刚添加的字符不在 needs 里（needs[chIdx] 为 0），
            // 或者滑动窗口中该字符的个数大于 needs 中的个数
            while (window[chIdx] > needs[chIdx]) {
                window[sChars[l] - 'a']--;
                l++;
            }
            // 因为将 needs 中不存在的字符和多数的字符都从滑动窗口中移除掉了，
            // 所以如果滑动窗口的长度等于目标字符串长度，就代表符合条件
            if (r - l == pChars.length) res.add(l);
        }
        return res;
    }

    /**
     * 将字符串通过字符个数编码，
     * 比较暴力
     */
    public List<Integer> findAnagramsStringEncoding(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) return result;

        int pLen = p.length();
        String pCode = encoding(p, 0, pLen - 1);
        for (int i = 0; i < s.length() - pLen + 1; i++) {
            if (pCode.equals(encoding(s, i, i + pLen - 1))) {
                result.add(i);
            }
        }
        return result;
    }

    private String encoding(String p, int start, int end) {
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[p.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< 26; i++) {
            sb.append('a' + i);
            sb.append(count[i]);
        }
        return sb.toString();
    }
}
