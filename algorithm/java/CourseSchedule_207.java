import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 */
public class CourseSchedule_207 {
    /**
     * 拓扑排序
     * 广度优先遍历，入度表
     * 先遍历一遍入度表，将入度为 0 的
     * 还可以使用深度优先遍历
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] pr : prerequisites) {
            indegrees[pr[0]]++;
            adjacency.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            numCourses--;
            for (int adj : adjacency.get(course)) {
                if (--indegrees[adj] == 0) queue.add(adj);
            }
        }
        return numCourses == 0;
    }
}
