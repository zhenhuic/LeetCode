import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 */
public class MergeIntervals_56 {
    /**
     * 合并 2 个区间
     * 2 个区间的关系有以下 6 种，
     * 但是其实可以变成上面 3 种情况
     * 只需要假设 第一个区间的起始位置 ≤ 第二个区间的起始位置，
     * 如果不满足这个假设，交换这两个区间（先对区间排序）。
     * 这 3 种情况的合并的逻辑都很好写。
     * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int idx = -1;
        int[][] result = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (idx == -1 || result[idx][1] < interval[0]) {
                result[++idx] = interval;
            } else {
                result[idx][1] = Math.max(result[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, idx + 1);
    }
}
