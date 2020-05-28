/**
 * 11. 盛最多水的容器
 */
public class ContainerWithMostWater_11 {
    /**
     * 双指针法
     * 初始 l = 0，r = len - 1，
     * 计算区域面积，与最大值比较
     * 移动指针，如果 l 位置的高度较小，则 l++，否则，r--。
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return area;
    }
}
