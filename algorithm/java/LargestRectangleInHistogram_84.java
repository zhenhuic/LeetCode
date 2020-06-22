import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 困难
 */
class LargestRectangleInHistogram_84 {
    /**
     * 暴力解法
     * 枚举以每个柱形为高度的最大矩形的面积，
     * 依次遍历柱形的高度，对于每一个高度分别向两边扩散，
     * 求出以当前高度为矩形的最大宽度多少。
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }
            int width = right - left + 1;
            maxArea = Math.max(maxArea, width * curHeight);
        }
        return maxArea;
    }

    /**
     * 单调栈
     * 栈中只存放高度递增的矩形的索引，
     * 如果遇到递减的就弹出，
     * 计算以弹出的这个矩形的高度最大宽度的面积，
     * 宽度就是 当前的索引 - 栈顶的索引，
     * 因为栈顶的矩形的高度和当前矩形的高度都比弹出来的这个矩形小。
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     */
    public int largestRectangleAreaStack(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        if (len == 1) return heights[0];

        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int currHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == currHeight) {
                    stack.pollLast();
                }
                int currWidth;
                if (stack.isEmpty()) currWidth = i;
                else currWidth = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int currHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == currHeight) {
                stack.pollLast();
            }
            int currWidth;
            if (stack.isEmpty()) currWidth = len;
            else currWidth = len - stack.peekLast() - 1;
            maxArea = Math.max(maxArea, currWidth * currHeight);
        }
        return maxArea;
    }

    /**
     * 单点栈，哨兵技巧
     * 数组的前后设置两个高度为0的哨兵，
     * 这样在循环里就不用做非空判断。
     */
    public int largestRectangleAreaSentry(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        if (len == 1) return heights[0];

        int maxArea = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        int newLen = newHeights.length;

        Deque<Integer> stack = new ArrayDeque<>(newLen);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < newLen; i++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                int curHeight = newHeights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return maxArea;
    }
}
