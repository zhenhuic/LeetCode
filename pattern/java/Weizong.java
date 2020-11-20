import java.util.Scanner;

public class Weizong {
    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        backtrack(nums, 0, new int[3], 0);
        System.out.println(ret);
    }

    private static void backtrack(int[] nums, int i, int[] triple, int j) {
        if (j >= 3) {
            if (triple[0] <= triple[1] && triple[1] <= triple[2]) ret++;
            return;
        }
        for (int k = i; k < nums.length; k++) {
            triple[j] = nums[k];
            backtrack(nums, k + 1, triple, j + 1);
        }
    }
}
