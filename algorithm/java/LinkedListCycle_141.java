import entity.ListNode;

/**
 * 141. 环形链表
 */
public class LinkedListCycle_141 {
    /**
     * 快慢指针
     * 通过使用具有不同速度的快、慢两个指针遍历链表，
     * 空间复杂度可以被降低至 O(1)。
     * 慢指针每次移动一步，而快指针每次移动两步。
     * 为什么快慢指针一定能相遇？
     * 考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，
     * 在下一次迭代中，它们就会分别跑了一步或两步并相遇。
     * 如果快跑者在慢跑者之后两步或三步的情况，
     * 在下一次或者下下次迭代后，又会变成上面提到的情况 A。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
