import java.util.Scanner;

public class ZTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(Math.min(helper(nums, false), helper(nums, true)));
        }
    }

    private static int helper(int[] nums, boolean desc) {
        int len = nums.length;
        int[] dp = new int[len];
        int longest = 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (desc ? nums[i] <= nums[j] : nums[i] >= nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            longest = Math.max(longest, dp[i]);
        }
        return len - longest;
    }
}
