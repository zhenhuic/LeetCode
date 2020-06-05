import entity.ListNode;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapNodesInPairs_24 {
    /**
     * 递归回溯
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        return swapPairsCore(head, head.next);
    }

    private ListNode swapPairsCore(ListNode n1, ListNode n2) {
        if (n2 == null) return n1;
        ListNode next = n2.next;
        n2.next = n1;
        n1.next = next != null ? swapPairsCore(next, next.next) : null;
        return n2;
    }
}
