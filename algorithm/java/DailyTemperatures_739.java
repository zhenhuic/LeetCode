import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 */
public class DailyTemperatures_739 {
    /**
     * 单调栈，栈内存数字的索引
     * 从后往前，将栈内小于当前数的都删掉，
     * 因为这些数不可能成为以后数的第一个较大值，
     * 然后找到比当前值较大的第一个数的索引。
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        int n = T.length;
        int[] res = new int[n];
        res[n - 1] = 0;
        stack.addLast(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peekLast()] <= T[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peekLast() - i;
            }
            stack.addLast(i);
        }
        return res;
    }
}
