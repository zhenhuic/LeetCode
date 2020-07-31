import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 */
public class QueueReconstructionByHeight_406 {
    /**
     * 因为矮的人对于高的人来说就是看不见的，
     * 所以先对高的人进行排序，以他的 k 作为索引放到队列中的位置，
     * 再拿身高较低的人来插入队列，插入的位置索引就是他的 k 值。
     * 这样排列策略的内在原因是：
     * 将身高矮的人插入到队列对之前身高较高的人是没有影响的，
     * 以 k 为索引插入队列就代表他前面身高有几个大于或等于他的人。
     * https://www.bilibili.com/video/BV1xC4y1a72W
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) ->
                p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]
        );
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
