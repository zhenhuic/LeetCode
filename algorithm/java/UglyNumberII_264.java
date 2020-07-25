/**
 * 264. 丑数 II
 */
public class UglyNumberII_264 {
    /**
     * 动态规划
     * 也可以用堆
     */
    public int nthUglyNumber(int n) {
        Ugly ug = new Ugly();
        return ug.getUgly(n);
    }

    static class Ugly {
        int[] arr;

        Ugly () {
            arr = new int[1690];
            arr[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < 1690; i++) {
                int ugly = Math.min(arr[p2] * 2,
                        Math.min(arr[p3] * 3, arr[p5] * 5));
                if (ugly == arr[p2] * 2) p2++;
                if (ugly == arr[p3] * 3) p3++;
                if (ugly == arr[p5] * 5) p5++;
                arr[i] = ugly;
            }
        }

        public int getUgly(int n) {
            return arr[n - 1];
        }

    }
}
