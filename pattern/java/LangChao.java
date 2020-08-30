import java.util.Scanner;

public class LangChao {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        int[] up = new int[n];
        int[] down = new int[101];
        for (int i = 0; i < 100; i++) {
            down[i + 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            up[i] = sc.nextInt();
            down[up[i]] = 0;

        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                if (down[i] == 0) {
                    sb1.append(" ");
                } else {
                    if (i < 10) {
                        sb1.append("00");
                        sb1.append(i);
                    } else if (i < 100) {
                        sb1.append("0");
                        sb1.append(i);
                    } else {
                        sb1.append(i);
                    }
                }
            } else {
                if (down[i] == 0) {
                    sb2.append(" ");
                } else {
                    if (i < 10) {
                        sb2.append("00");
                        sb2.append(i);
                    } else if (i < 100) {
                        sb2.append("0");
                        sb2.append(i);
                    } else {
                        sb2.append(i);
                    }
                }
            }
        }

        int max = 0;
        String start = "";
        String[] s1 = sb1.toString().split(" ");
        String[] s2 = sb2.toString().split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (max < s1[i].length()) {
                max = s1[i].length();
                start = s1[i].substring(0, 3);
            }
        }
        for (int i = 0; i < s2.length; i++) {
            if (max < s2[i].length()) {
                max = s2[i].length();
                start = s2[i].substring(0, 3);
            }

        }
        int st = Integer.parseInt(start);
        System.out.println(st + " " + max / 3);
    }
    public static void main1(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i] = sc.nextInt();
        }
        if (cnt < 1) {
            System.out.println(0);
            return;
        }
        int max = 1;
        for (int i = 0; i < cnt; i++) {
            int num = nums[i];
            int tmp = 1;
            for (int j = i + 1; j < cnt; j++) {
                if (num + 1 == nums[j]) {
                    tmp++;
                    num = nums[j];
                }
            }
            max = Math.max(tmp, max);
        }

        System.out.println(cnt - max);
    }
}
