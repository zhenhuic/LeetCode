/**
 * 4. 寻找两个正序数组的中位数
 */
class MedianOfTwoSortedArrays {
    /**
     * 比较两个数组中 nums1[k / 2] 和 nums2[k / 2]的数，
     * 排除掉较小那 k / 2 部分的数，更新 k，
     * 出口就是当 k=1 或者其中一个数字长度是 0 了。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 防止最后数组长度小于 k/2，所以每次比较 min(k/2, len(数组) 对应的数字，
        // 把小的那个对应的数组的数字排除，将两个新数组进入递归
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays p = new MedianOfTwoSortedArrays();
        System.out.println(p.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}));
    }
}