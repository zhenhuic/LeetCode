import java.util.*;

/**
 * 第 198 场周赛
 */
public class NumberOfNodesWithTheSameLabelInTheSubtree_5465 {
    /**
     * 5464. 换酒问题
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int numDrink = numBottles;
        int numRemain = numBottles;

        while (numRemain >= numExchange) {
            numDrink += numRemain / numExchange;
            numRemain = numRemain % numExchange + numRemain / numExchange;
        }
        return numDrink;
    }

    /**
     * 5465. 子树中标签相同的节点数
     * 超出时间限制
     * 这道题主要在于图的构建，
     * 题中只给出两个节点之间的边缘，
     * 没有说明这两个节点在树中哪个是父节点，哪个是子节点，这个需要自己判断。
     * 下面的题解是用 HashMap 构建图的邻接表，
     * 这是由于一开始题目理解有误，以为一个节点可能有多个父节点。
     * 其实可以用邻接矩阵或者一个数组就能构建出图了，
     * 因为在树中，每个节点只有一个父节点。
     *
     * 其实想想 用深度遍历 + 回溯就可以了，这样最快，
     * 从根节点出发，深度遍历所有节点，将所有父节点以上的节点和个数用 HashMap 保存，
     * 遇到 HashMap 中存在的，该节点父节点以上相同的都自增 1。
     */
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] labelsChars = labels.toCharArray();

        Map<Integer, List<Integer>> parents = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> parentsList0 = parents.get(edge[0]);
            List<Integer> parentsList1 = parents.get(edge[1]);
            int father, son;
            if (parentsList0 == null && parentsList1 == null) {
                if (edge[0] < edge[1]) {
                    father = edge[0];
                    son = edge[1];
                } else {
                    father = edge[1];
                    son = edge[0];
                }
            } else if (parentsList0 == null) {
                father = edge[1];
                son = edge[0];
            } else {
                father = edge[0];
                son = edge[1];
            }

            List<Integer> parentsList = parents.get(son);
            if (parentsList == null) {
                parentsList = new ArrayList<>();
                parents.put(son, parentsList);
            }
            parentsList.add(father);
        }

        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i = 0; i < n; i++) {
            char ch = labelsChars[i];
            findParent(parents, i, ch, labelsChars, result);
        }
        return result;
    }

    private void findParent(Map<Integer, List<Integer>> parents, int node, char ch,
                            char[] labelsChars, int[] result) {
        List<Integer> parentsList = parents.get(node);
        if (parentsList != null) {
            for (int parent : parentsList) {
                if (ch == labelsChars[parent]) {
                    result[parent]++;
                }
                findParent(parents, parent, ch, labelsChars, result);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfNodesWithTheSameLabelInTheSubtree_5465 s = new NumberOfNodesWithTheSameLabelInTheSubtree_5465();
        System.out.println(Arrays.toString(s.countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed")));
    }
}
