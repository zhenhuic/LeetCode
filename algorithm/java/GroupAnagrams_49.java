import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams_49 {
    /**
     * 按计数分类
     * 维护一个长度为 26 的 int 数组，
     * 数组的值代表字母出现的次数，
     * 再将这个数组转成 String，
     * 用这个字符串作为 Map 的 key 来分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');  // 这里不一定中间用'#'隔开
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    /**
     * 第二遍写
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            List<String> list = map.get(code);
            if (list == null) {
                list = new ArrayList<>();
                map.put(code, list);
            }
            list.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    private String encode(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                code.append('a' + i);
                code.append(count[i]);
            }
        }
        return code.toString();
    }
}
