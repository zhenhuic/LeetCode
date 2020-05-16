import entity.ListNode;

/**
 * 25. K 个一组翻转链表
 */
class ReverseNodesInKGroup {
    /**
     * 把大任务分成小任务，理清思路再动手
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;  // 题目是如果最后不足 k 个节点就不反转了
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, pre = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}