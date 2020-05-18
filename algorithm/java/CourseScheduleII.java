import java.util.*;

/**
 * 210. 课程表 II
 */
class CourseScheduleII {
    /**
     * 拓扑排序
     * 先将入度为 0 的节点放入队列，
     * 从队列中取出节点，将该节点所有的相邻节点的入度减 1，
     * 如果相邻节点的入度变为 0，那么就将该节点放入队列。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjList.put(src, list);
            inDegree[dest] += 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }
}
