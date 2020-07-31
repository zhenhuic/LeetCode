import java.util.Arrays;

/**
 * 621. 任务调度器
 */
public class TaskScheduler_621 {
    /**
     * 将任务个数排序，贪心算法
     * 在一个 n+1 周期里先执行任务个数最多的。
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        int[] count = new int[26];
        for (int t : tasks) {
            count[t - 'A']++;
        }
        int time = 0;
        Arrays.sort(count);
        while (count[25] > 0) {
            for (int i = 0; i <= n; i++) {
                if (count[25] == 0) break;  // 最后一轮没有任务后提前结束
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;
                }
                time++;
            }
            Arrays.sort(count);
        }
        return time;
    }
}
