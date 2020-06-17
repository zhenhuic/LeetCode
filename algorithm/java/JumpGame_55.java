/**
 * 55. 跳跃游戏
 */
public class JumpGame_55 {
    /**
     * 设置一个 rightmost 变量，表示最右边能到达的位置，
     * 只要 rightmost >= i，
     * 就表示能到达 i 位置。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        int rightmost = 0;
        for (int i = 0; i < len; i++) {
            // 这里代表经过前面的跳跃，可以跳到 i 位置，
            // 如果 rightmost < i，那就根本到达不了这个位置
            if (rightmost >= i) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= len - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
