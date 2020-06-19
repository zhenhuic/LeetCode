/**
 * 70. 爬楼梯
 */
public class ClimbingStairs_70 {
    /**
     * 动态规划
     * 因为一次只能爬 1 或 2 个台阶，
     * 所以只需要存储前两次的结果。
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int a = 0, b = 0, c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
