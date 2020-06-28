import entity.ListNode;

/**
 * 234. 回文链表
 */
public class PalindromeLinkedList_234 {
    /**
     * 先用快慢指针找到链表的中间节点，
     * （如果是偶数个节点，就是前半段的末尾节点；如果是奇数个节点，就是中间节点）
     * 然后反转后半段链表，
     * 再逐个比较后半段链表和前半段链表，
     * 最后将链表恢复原样。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode end1 = endOfFirstHalf(head);
        ListNode end2 = reverseLinkedList(end1.next);

        ListNode p1 = head, p2 = end2;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        end1.next = reverseLinkedList(end2);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
