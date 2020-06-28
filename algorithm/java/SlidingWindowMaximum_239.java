import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 */
public class SlidingWindowMaximum_239 {
    /**
     * 单调队列，双向队列
     * 在遍历数组的过程中，单调队列中维护着递减的数据的索引，
     * 队列的第一个元素就是当前滑动窗口的最大值的索引，
     * 当窗口滑动时，如果队列第一个元素被滑出窗口，就 removeFirst()，
     * 然后将队列从后往前与刚滑入的元素比较，删除比该元素小的索引，
     * 因为较小的元素在后面不可能成为最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length)
            return new int[0];

        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            cleanDeque(dq, nums, i, k);
            dq.addLast(i);
        }
        int[] result = new int[len - k + 1];
        result[0] = nums[dq.getFirst()];
        for (int i = k; i < len; i++) {
            cleanDeque(dq, nums, i, k);
            dq.addLast(i);
            result[i - k +1] = nums[dq.getFirst()];
        }
        return result;
    }

    private void cleanDeque(Deque<Integer> dq, int[] nums, int i, int k) {
        if (!dq.isEmpty() && dq.getFirst() == i - k) {
            dq.removeFirst();
        }
        while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
            dq.removeLast();
        }
    }
}
