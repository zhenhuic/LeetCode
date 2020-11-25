import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class Problem45 {
    /**
     * 就是比较 s1 + s2 和 s2 + s1 的字典序
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
