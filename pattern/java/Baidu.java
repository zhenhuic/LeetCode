import java.util.Scanner;

public class Baidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int bull = sc.nextInt();
            int cond = sc.nextInt();
            int[] ans = new int[bull];
            int cnt = 0;
            for (int j = 0; j < cond; j++) {
                boolean[] flag = new boolean[bull];
                int partition = sc.nextInt();
                for (int k = 0; k < partition; k++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    while (l <= r) {
                        if (!flag[l]) {
                            ans[l]++;
                            flag[l] = true;
                        }
                        if (ans[l] == cond) cnt++;
                        l++;
                    }
                }
            }
            if (i != 0) System.out.println();
            System.out.println(cnt);
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == cond) System.out.print(j + " ");
            }
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mod = (int) 1e9 + 7;
        int[][][] help = new int[n + 1][m + 1][m + 1];
        help[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k == j) continue;
                    for (int l = 0; l <= m; l++) {
                        if (i - k == 0 && j == 0) {
                            help[i][k][j] = 1;
                            continue;
                        }
                        if (l == k || i - k <= 0) continue;
                        help[i][k][j] += help[i - k][j][l];
                        help[i][k][j] %= mod;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                sum += help[n][i][j];
                sum %= mod;
            }
        }
        System.out.println(sum);
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zeroCnt = 0;
        int fiveCnt = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) zeroCnt++;
            if (num == 5) fiveCnt++;
        }
        if (zeroCnt == 0) {
            System.out.println(-1);
            return;
        }
        int cnt = fiveCnt / 9;
        if (cnt == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < cnt * 9; i++) {
                System.out.print(5 + "");
            }
            for (int i = 0; i < zeroCnt; i++) {
                System.out.print(0 + "");
            }
        }
    }
}
