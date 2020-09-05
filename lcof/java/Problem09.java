import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class Problem09 {
    static class CQueue {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public CQueue() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            q1.add(value);
        }

        public int deleteHead() {
            if(q2.isEmpty()) {
                while (!q1.isEmpty()) {
                    q2.add(q1.poll());
                }
            }
            return q2.isEmpty() ? -1 : q2.poll();
        }
    }
}

