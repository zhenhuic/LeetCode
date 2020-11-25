import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NetEase {
    public static void main(String[] args) {

    }



    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            arr[j][k] += 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (arr[i][j] > 0) {
                    for (int k = 1; k <= n; k++) {
                        arr[i][k] += arr[j][k];
                    }
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] > 0 && arr[j][i] > 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static int minValue = Integer.MAX_VALUE;

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            minValue = Integer.MAX_VALUE;
            helper(nums, sum);
        }
    }

    private static void helper(int[] nums, int sum) {
        dfs(nums, 0, 0, 0, sum);
        System.out.println(minValue);
    }

    private static void dfs(int[] nums, int index, int sum1, int sum2, int sums) {
        if (index == nums.length && sum1 == sum2) {
            minValue = Math.min(minValue, sums - sum1 * 2);
        }
        if (index >= nums.length) {
            return;
        }
        dfs(nums, index + 1, sum1, sum2, sums);
        dfs(nums, index + 1, sum1 + nums[index], sum2, sums);
        dfs(nums, index + 1, sum1, sum2 + nums[index], sums);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] T = new int[m];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            T[i] = t;
            set.add(t);
        }
        StringBuilder ret = new StringBuilder();
        int cur = 1;
        for (int i = 0; i < m; i++) {
            while (cur <= n || i < m) {
                if (set.contains(cur)) {
                    cur++;
                } else if (cur > T[i]) {
                    ret.append(T[i]).append(" ");
                    break;
                } else {
                    ret.append(cur).append(" ");
                    cur++;
                }
            }
        }
        while (cur <= n) {
            ret.append(cur).append(" ");
            cur++;
        }
        System.out.println(ret.toString());
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            sum += (a >> 1);
        }
        System.out.println(sum);
    }
}
