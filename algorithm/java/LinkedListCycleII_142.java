import entity.ListNode;

/**
 * 142. 环形链表 II
 */
public class LinkedListCycleII_142 {
    /**
     * slow 指针位置不变，
     * 将 fast指针重新 指向链表头部节点，
     * slow 和 fast 同时每轮向前走 1 步。
     * 不用计算环内节点的个数。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 先快慢指针找到环，
     * 再遍历一遍环，计算环中节点的个数，
     * 重新从头结点设置快慢指针，
     * 让快指针从头节点开始先走环的个数步，
     * 最后快慢指针每轮向前走一步，
     * 相遇的节点就是环的入口。
     */
    public ListNode detectCycleNormal(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        int cycCnt = 1;
        while ((slow = slow.next) != fast) {
            cycCnt++;
        }
        slow = fast = head;
        while (cycCnt-- > 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
