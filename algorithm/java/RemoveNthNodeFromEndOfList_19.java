import entity.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromEndOfList_19 {
    /**
     * 双指针法，快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0 ) return head;
        ListNode front = head, rear = head;
        int i = 0;
        for (; i < n + 1 && front != null; i++) {
            front = front.next;
        }
        if (i < n) return head;
        if (i == n) return head.next;
        while (front != null) {
            front = front.next;
            rear = rear.next;
        }
        rear.next = rear.next.next;
        return head;
    }

    /**
     * 第二次写的更清楚
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
