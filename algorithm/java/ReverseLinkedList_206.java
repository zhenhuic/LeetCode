import entity.ListNode;

/**
 * 206. 反转链表
 */
public class ReverseLinkedList_206 {
    /**
     * 迭代法
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode next = null, tmp = null;
        while (head.next != null) {
            tmp = head.next;
            head.next = next;
            next = head;
            head = tmp;
        }
        head.next = next;
        return head;
    }

    /**
     * 递归法
     * 设置当前节点的下一个节点，
     * 将前一个节点也传进去
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        return reverseListRecursiveCore(head, null);
    }

    private ListNode reverseListRecursiveCore(ListNode node, ListNode next) {
        ListNode tmp = node.next;
        if (tmp == null) {
            node.next = next;
            return node;
        } else {
            node.next = next;
            return reverseListRecursiveCore(tmp, node);
        }
    }
}
