import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        float[][][] prob = new float[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    prob[i][j][k] = sc.nextFloat();
                }
            }
        }

        float[][] dp = new float[n][m];
        dp[0][1] =  1 / prob[0][0][1];
        dp[1][0] =  1 / prob[0][0][0];
        for (int i = 2; i < m; i++) {
            dp[0][i] = dp[0][i - 1] - 0.0f > 1e-3 && prob[0][i - 1][1] - 0.0f > 1e-3 ? dp[0][i - 1] + (1 / prob[0][i - 1][1]) : 0.0f;
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] - 0.0f > 1e-3 &&  prob[i - 1][0][0] - 0.0f > 1e-3 ? dp[i - 1][0] + (1 / prob[i - 1][0][0]) : 0.0f;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = (dp[i - 1][j] - 0.0f > 1e-3 &&  prob[i - 1][j][0] - 0.0f > 1e-3 ? dp[i - 1][j] + (1 / prob[i - 1][j][0]) : 0.0f) +
                        (dp[i][j - 1]  - 0.0f > 1e-3 &&  prob[i][j - 1][1]  - 0.0f > 1e-3 ? dp[i][j - 1] + (1 / prob[i][j - 1][1]) : 0.0f);
            }
        }
        System.out.println(dp[n - 1][m - 1]);

    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> in = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            in.add(s);
            if (s.length() == 1) {
                in.add(sc.next());
                break;
            }
        }
        char A = in.get(in.size() - 2).charAt(0);
        String subFeature = feature(in.get(in.size() - 1), A);
        for (int i = 0; i < in.size() - 2; i++) {
            String str = in.get(i);
            if (isSubstring(feature(str, A), subFeature)) {
                System.out.println(str);
            }
        }
    }

    private static boolean isSubstring(String str,String subStr) {
        if (str.length() < subStr.length()) return false;
        for (int i = 0; i < str.length() - subStr.length() + 1; i++) {
            boolean match = true;
            for (int j = 0; j < subStr.length(); j++) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }

    private static String feature(String str, char A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < A) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

