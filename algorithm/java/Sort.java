import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
//        int[] arr = {5, 18, 9, 6, 34, 9, 10, 613, 4, 6, 50};
        int[] arr = {25,84,21,47,15,27,68,35,20};

//        sort.shellSort(arr);
//        sort.mergeSort(arr);
        sort.quickSort(arr);
//        sort.heapSort(arr);
//        sort.radixSort(arr);
//        sort.insertSort(arr);
//        sort.bubbleSort(arr);
//        sort.selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }


    /**
     * 直接插入排序
     */
    public void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = num;
        }
    }

    /**
     * 简单选择排序
     */
    public void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int maxIdx = i;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[maxIdx]) {
                    maxIdx = j;
                }
            }
            swap(nums, i, maxIdx);
        }
    }

    /**
     * 希尔排序
     */
    public void shellSort(int[] nums) {
        int len = nums.length;

        // 设置分组区间
        int gap = 1;
        // 1, 4, 13, 40, 121, 364, ...
        while (gap < len) gap = gap * 3 + 1;

        // 知道分组间隔减小到 1
        while (gap >= 1) {
            // 对每个分组进行排序
            for (int i = gap; i < len; i++) {
                // 组内进行插入排序
                int tmp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = tmp;
            }
            gap /= 3;  // 调整分组间隔
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    private void mergeSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(nums, left, mid);
            mergeSortHelper(nums, mid + 1, right);
            mergeHelper(nums, left, mid, right);
        }
    }

    private void mergeHelper(int[] nums, int left, int mid, int right) {
        // 创建一个临时数组，保存中间排序结果
        int[] tmpArr = new int[nums.length];
        int l = left, r = mid + 1, tmpIdx = left;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                tmpArr[tmpIdx++] = nums[l++];
            } else {
                tmpArr[tmpIdx++] = nums[r++];
            }
        }

        // 剩余部分依次放入临时数组，
        // 下面两个循环只会执行一个
        while (l <= mid) {
            tmpArr[tmpIdx++] = nums[l++];
        }
        while (r <= right) {
            tmpArr[tmpIdx++] = nums[r++];
        }

        // 将临时数组中的排好序的复制到原数组中
        while (left <= right) {
            nums[left] = tmpArr[left];
            left++;
        }
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private void quickSortHelper(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivotIdx = partition(nums, left, right);
        quickSortHelper(nums, left, pivotIdx - 1);
        quickSortHelper(nums, pivotIdx + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int idx = left;  // nums[left..idx] 是小于等于基准值的数
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++idx, i);
            }
        }
        nums[left] = nums[idx];
        nums[idx] = pivot;
        return idx;
    }

    /**
     * 堆排序
     * 某节点在数组中的索引为 i，
     * 父节点索引 parent = (i - 1) / 2，
     * 左子节点索引 left = i * 2 + 1，
     * 右子节点索引 right = i * 2 + 2
     */
    public void heapSort(int[] nums) {
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private void buildHeap(int[] nums, int length) {
        // (length - 1 - 1) / 2 表示最后一个节点的父节点
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            heapify(nums, i, length);
        }
    }

    /**
     * 从 index 位置下沉调整
     */
    private void heapify(int[] nums, int index, int length) {
        int leftChild = index * 2 + 1;  // 左子节点索引
        int rightChild = index * 2 + 2;  // 右子节点索引
        int cur = index;

        // 找出当前节点和左右子节点中值最大的节点
        if (leftChild < length && nums[leftChild] > nums[cur]) {
            cur = leftChild;
        }
        if (rightChild < length && nums[rightChild] > nums[cur]) {
            cur = rightChild;
        }

        // 当前节点不是最大的，做交换，
        // 交换后，其子节点可能就不符合堆要求了，需要继续调整
        if (cur != index) {
            swap(nums, cur, index);
            heapify(nums, cur, length);
        }
    }

    /**
     * 基数排序
     */
    public void radixSort(int[] nums) {
        int len = nums.length;
        // 找出最大数
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        // 计算位数
        int time = 0;
        while (max > 0) {
            time++;
            max /= 10;
        }
        // 构造索引 0-9 的桶
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }

        // 依次从低位到高位
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < len; j++) {
                // 求出第 i 位的数
                int digit = nums[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                bucket.get(digit).add(nums[j]);
            }
            // 按顺序放到原数组，并清空桶
            int idx = 0;
            for (int j = 0; j < 10; j++) {
                List<Integer> list = bucket.get(j);
                for (int n : list) {
                    nums[idx++] = n;
                }
                list.clear();
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
