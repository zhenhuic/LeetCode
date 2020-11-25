import java.util.Scanner;

public class ByteDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int l = 0, r = 1;
        int sum = nums[l];
        long maxSum = sum;
        while (r < m * n) {
            int ri = r % n;
            if (nums[ri] < 0) {
                maxSum = Math.max(maxSum, sum);
            }
            sum += nums[ri];
            r++;
            while (l < r && sum < 0) {
                sum -= nums[l % n];
                l++;
            }
        }
        maxSum = Math.max(maxSum, sum);
        System.out.println(maxSum);
    }
}
