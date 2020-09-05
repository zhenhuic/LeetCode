import entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Problem06 {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}
