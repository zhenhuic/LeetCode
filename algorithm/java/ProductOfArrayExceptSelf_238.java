/**
 * 238. 除自身以外数组的乘积
 */
public class ProductOfArrayExceptSelf_238 {
    /**
     * 左右乘积列表
     * 索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案
     * 求右侧所有数字的乘积时，
     * 用一个变量保存索引右边一个的后缀乘积，
     * 这样实现 O(1) 空间复杂度
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int len = nums.length;
        int[] mul = new int[len];
        mul[0] = 1;
        for (int i = 1; i < len; i++) {
            mul[i] = mul[i - 1] * nums[i - 1];
        }

        int rMul = 1;
        for (int i = len - 2; i >= 0; i--) {
            rMul *= nums[i + 1];
            mul[i] *= rMul;
        }
        return mul;
    }
}
