import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Bilibili {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                stack.addLast(')');
            } else if (c == '{') {
                stack.addLast('}');
            } else if (c == '[') {
                stack.addLast(']');
            } else if (stack.isEmpty() || c != stack.pollLast()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    boolean ret = false;
    public boolean Game24Points (int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        helper(arr, set, arr[0]);
        return ret;
    }

    private void helper(int[] nums, Set<Integer> set, int sum) {
        if (set.size() == 4 && sum != 24) return;
        if (sum == 24) {
            ret = true;
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (set.add(nums[i])) {
                helper(nums, set, sum + nums[i]);
                helper(nums, set, sum * nums[i]);
                helper(nums, set, sum - nums[i]);
                helper(nums, set, sum / nums[i]);
                set.remove(nums[i]);
            }
        }
    }

    public int GetCoinCount (int N) {
        // write code here
        int s = 0;
        N = 1024 - N;
        s += N / 64;
        N %= 64;
        s += N / 16;
        N %= 16;
        s += N / 4;
        N %= 4;
        s += N;
        return s;
    }
}
