/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Problem11 {
    /**
     * 因为是找最小值，
     * 所以需要比较的是中间数字和有边界数字的大小
     */
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}
