import java.util.ArrayList;
import java.util.Arrays;

/**
 * 287. 寻找重复数
 */
public class FindTheDuplicateNumber_287 {
    /**
     * 快慢指针
     * 我们先设置慢指针 slow 和快指针 fast，
     * 慢指针每次走一步，快指针每次走两步，
     * 根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，
     * 此时我们再将 slow 放置起点 0，
     * 两个指针每次同时移动一步，相遇的点就是答案。
     */

    public int findDuplicateFastSlowPointer(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 位计数法
     * 考虑到第 i 位，我们记 nums[] 数组中二进制展开后第 i 位为 1 的数有 x 个，
     * 数字 [1,n] 这 n 个数二进制展开后第 i 位为 1 的数有 y 个，
     * 那么重复的数第 i 位为 1 当且仅当 x > y。
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length - 1;
        int bitMax = 31;
        while ((n >> bitMax) == 0) bitMax--;

        int ans = 0;
        for (int i = bitMax; i >= 0; i--) {
            int numBit = 0, numBitOrig = 0;
            for (int j = 0; j <= n; j++) {
                if ((nums[j] & (1 << i)) != 0)
                    numBit++;
                if (j > 0 && (j & (1 << i)) != 0)
                    numBitOrig++;
            }
            if (numBit > numBitOrig) ans |= 1 << i;
        }
        return ans;
    }
}
