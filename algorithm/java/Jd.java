import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Jd {
    /**
     * 数列转换
     */
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList<Long> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] strs = sc.nextLine().split(" ");
            int op = Integer.parseInt(strs[0].trim());
            if (op == 3) {
                list.forEach(o -> System.out.print(o + " "));
            } else if (op == 1) {
                list.add(Integer.parseInt(strs[1].trim()) - 1,
                        Long.parseLong(strs[2].trim()));
            } else if (op == 2) {
                list.remove(Integer.parseInt(strs[1].trim()) - 1);
            }
        }
    }

    /**
     * 滚球游戏
     */
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        int len = 2 * depth - 1;

        int[] up = new int[len];
        int[] cur = new int[len];

        int offset = len >> 1;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                int idx = offset + j;
                cur[idx] = Math.max(idx - 1 >= 0 ? up[idx - 1] : 0,
                        Math.max(up[idx], idx + 1 < len ? up[idx + 1] : 0)) + sc.nextInt();
            }
            offset--;
            Arrays.fill(up, 0);
            int[] tmp = up;
            up = cur;
            cur = tmp;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(up[i], max);
        }
        System.out.println(max);
    }

    /**
     * 滚球游戏
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        int len = 2 * depth - 1;
        long[][] arr = new long[depth][len];
        for (int i = 0; i < depth; i++) {
            for (int j = depth - i - 1; j < depth; j++) {
                arr[i][j] = sc.nextInt();

            }
        }
        System.out.println(path(arr, 0, depth - 1, depth, 0));
    }

    public static long path(long[][] arr, int i, int j, int depth, long sum) {
        if (i == depth) {
            return sum;
        }
        sum += arr[i][j];
        return Math.max(path(arr, i + 1, j - 1, depth, sum),
                Math.max(path(arr, i + 1, j, depth, sum),
                        path(arr, i + 1, j + 1, depth, sum)));
    }

    /**
     * 2, 3, 5
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1;
        LinkedList<Integer> res = new LinkedList<>();
        while (n >= 0) {
            res.addFirst((int)(n % 3));
            n = (n / 3) - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            switch (num) {
                case 0:
                    sb.append(2);
                    break;
                case 1:
                    sb.append(3);
                    break;
                case 2:
                    sb.append(5);
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
