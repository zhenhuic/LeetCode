import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 */
public class Problem41 {
    /**
     * 大小顶堆实现
     * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
     */
    static class MedianFinder {
        // 保存较小一半数和较大一半数的堆
        private Queue<Integer> smaller, larger;

        public MedianFinder() {
            smaller = new PriorityQueue<>((o1, o2) -> o2 - o1);  // 大顶堆
            larger = new PriorityQueue<>();  // 小顶堆
        }

        public void addNum(int num) {
            if (smaller.size() == larger.size()) {
                larger.add(num);
                smaller.add(larger.poll());
            } else {
                smaller.add(num);
                larger.add(smaller.poll());
            }
        }

        public double findMedian() {
            if (smaller.size() == larger.size()) {
                return (smaller.peek() + larger.peek()) / 2.0;
            } else {
                return smaller.peek();
            }
        }
    }

}
