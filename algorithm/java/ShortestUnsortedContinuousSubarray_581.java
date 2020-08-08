import java.util.Deque;
import java.util.LinkedList;

/**
 * 581. 最短无序连续子数组
 */
public class ShortestUnsortedContinuousSubarray_581 {
    /**
     * 用一个单调栈，前后遍历两次，跟栈顶的数比较，
     * 找到左右边界
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int l = len - 1, r = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                l = Math.min(l, stack.pollLast());
            }
            stack.addLast(i);
        }

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                r = Math.max(r, stack.pollLast());
            }
            stack.addLast(i);
        }
        return r <= l ? 0 : r - l + 1;
    }
}
