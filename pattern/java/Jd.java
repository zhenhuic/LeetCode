import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            while (m.find()) {
                long year = Long.parseLong(m.group());
                if (year >= 1000 && year <= 3999) {
                    System.out.print(year + " ");
                }
            }
        }
    }

    public static void main111(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String y = m.group();
            if (y.length() >= 4) {
                for (int i = 0; i < y.length() - 3; i++) {
                    int year = Integer.parseInt(y.substring(i, i + 4));
                    if (year >= 1000 && year <= 3999) {
                        System.out.print(year + " ");
                    }
                }
            }
        }
    }


    public static void main22(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();

            int[] prince = new int[2];
            int[] princess = new int[2];

            int[][] map = new int[n][m];
            for (int j = 0; j < n; j++) {
                String s = sc.nextLine();
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    if (c == '.') {
                        map[j][k] = 1;
                    } else if (c == '#') {
                        map[j][k] = 0;
                    } else if (c == 'S') {
                        map[j][k] = 2;
                        prince[0] = j;
                        prince[1] = k;
                    } else if (c == 'E') {
                        map[j][k] = 1;
                        princess[0] = j;
                        princess[1] = k;
                    }
                }
            }
            boolean[][] visited = new boolean[n][m];
            if (dfs(map, prince[0], prince[1], visited, princess)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int[][] nums, int row, int col, boolean[][] visited, int[] target) {
        if (target[0] == row && target[1] == col) return true;
        int[] rowOffset = new int[]{-1, 0, 1, 0};
        int[] colOffset = new int[]{0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nextRow = row + rowOffset[i];
            int nextCol = col + colOffset[i];
            if (nextRow >= 0 && nextRow < nums.length &&
                    nextCol >= 0 && nextCol < nums[0].length &&
                    !visited[nextRow][nextCol] && nums[nextRow][nextCol] == 1) {
                visited[nextRow][nextCol] = true;
                if (dfs(nums, nextRow, nextCol, visited, target)) return true;
                visited[nextRow][nextCol] = false;
            }
        }
        return false;
    }


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
