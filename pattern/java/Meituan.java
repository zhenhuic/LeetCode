import java.util.Arrays;
import java.util.Scanner;

public class Meituan {
    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }
        String p = "^[a-zA-Z][a-zA-Z]*\\d+([a-zA-Z]*\\d*)*";
        for (String name : names) {
            System.out.println(name);
            boolean match = name.matches(p);
            if (match) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s;
        for (int i = 0; i < n; i++) {
            s = sc.next();
            if (judge(s)) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }

    public static boolean judge(String s) {
        if (s == null || s.length() == 0) return false;
        char first = s.charAt(0);
        if ((first >= 'a' && first <= 'z') || (first >= 'A' && first <= 'Z')) {
            int chCnt = 0;
            int numCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    numCnt++;
                } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    chCnt++;
                }else {
                    return false;
                }
            }
            return chCnt != 0 && numCnt != 0;
        }
        return false;
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[i][0] = v + w * 2;
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, (o1, o2) -> (o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]));
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = arr[i][1];
        }
        Arrays.sort(res);
        for (int i = 0; i < m; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main3_18(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            curSum += arr[i];
            sum[i] = curSum;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            for (int j = x; j < n; j++) {
                sum[j] -= arr[x];
            }
            System.out.println(Math.max(sum[x], sum[n - 1] - sum[x]));
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] take = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            take[i] = sc.nextInt();
        }

        int[] res = new int[n + 1];
        int[] tmp = new int[n];
        int max = 0;
        for (int i = n - 1; i > 0; i--) {
            int tk = take[i] - 1;
            tmp[tk] = tk == 0 ? weight[tk] : (tmp[tk - 1] + weight[tk]);
            int pos = tk;
            while (pos < n && tmp[pos] != 0) {
                pos++;
            }
            if (pos != tk + 1) {
                max = Math.max(tmp[tk] + tmp[pos - 1], max);
                tmp[pos - 1] = max;
            } else {
                max = Math.max(tmp[tk], max);
            }
            res[i] = max;
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.println(res[i]);
        }
    }

    int maxPower = 0;
    int[] maxTeam;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] all = new int[x + y];
        int allSum = 0;
        for (int i = 0; i < x + y; i++) {
            all[i] = sc.nextInt();
            allSum += all[i];
        }
        int n = Math.min(x, y);
        int[] team = new int[n];


    }
}











