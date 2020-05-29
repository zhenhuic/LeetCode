import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class RomanToInteger_13 {
    /**
     * 比较相邻两个字符代表的数字大小
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] nums = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] roms = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(roms[i], nums[i]);
        }

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                n += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            } else {
                n += map.get(s.charAt(i));
            }
        }
        return n;
    }

    public int romanToIntFast(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    /**
     * 数量较少的时候，这样比 Map 快
     */
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
