import java.util.*;

public class Didi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            boolean[][] bridge = new boolean[m + 1][m + 1];
            for (int j = 0; j < m; j++) {
                int i1 = sc.nextInt();
                int i2 = sc.nextInt();
                int fee = sc.nextInt();
                if (fee <= k) {
                    bridge[i1][i2] = true;
                    bridge[i2][i1] = true;
                }
            }
            Set<Integer> island = new HashSet<>();
            start:
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= m; l++) {
                    if (bridge[j][l]) {
                        dfs(bridge, j, island);
                        break start;
                    }
                }
            }
            if (island.size() == n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static void dfs(boolean[][] bridge, int i, Set<Integer> island) {
        island.add(i);
        for (int j = 1; j < bridge.length; j++) {
            if (bridge[i][j] && !island.contains(j)) {
                dfs(bridge, j, island);
            }
        }
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int len = s.length();
        for (int i = n - 1; i < len; i += n) {
            for (int j = i; j > i - n; j--) {
                System.out.print(s.charAt(j));
            }
        }
        if (len % n != 0) {
            for (int i = len - 1; i > len - 1 - (len % n); i--) {
                System.out.print(s.charAt(i));
            }
        }
    }
}
