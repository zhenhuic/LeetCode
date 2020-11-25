import java.util.*;

public class Qihu360 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int src = sc.nextInt();
        int tgt = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            graph[x][y] = w;
            graph[y][x] = w;
        }


    }

    static int min = Integer.MAX_VALUE;
    static int t, s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Map<Integer, List<int[]>> nodes = new HashMap<>();
        for (int[] item : edges) {
            List<int[]> list = nodes.computeIfAbsent(item[0], k -> new ArrayList<>());
            list.add(new int[]{item[1], item[2]});
        }
        dfs(s, Integer.MIN_VALUE, nodes);
        System.out.println(min);
    }

    private static void dfs(int i, int curMaxValue, Map<Integer, List<int[]>> nodes) {
        int maxValue = curMaxValue;
        for (int[] edge : nodes.get(i)) {
            if (edge[1] > maxValue) {
                maxValue = edge[1];
            }
            if (edge[0] == t) {
                if (maxValue < min) {
                    min = maxValue;
                }
                continue;
            } else {
                dfs(edge[0], maxValue, nodes);
            }
            maxValue = curMaxValue;
        }
    }

}
