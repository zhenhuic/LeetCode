import entity.ListNode;

/**
 * 160. 相交链表
 */
public class IntersectionOfTwoLinkedLists_160 {
    /**
     * 双指针法
     * 设置两个指针 pA，pB 分别指向 headA，headB，
     * 然后让它们向后逐点遍历，
     * 当 pA 到达链表的尾部时，将它指向 headB，
     * 当 pB 到达链表的尾部时，将它指向 headA，
     * 这样 pA 和 pB 在一次遍历过程中一定会相遇。
     * 这是因为这样两个指针到达相交节点的路程是一样的（画个图算一下就清楚了）。
     * 如果指针第二次为 null，那么代表两条链表没有相交。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        boolean turnA = true, turnB = true;
        while (pa != pb) {
            if (pa == null) {
                if (turnA) {
                    pa = headB;
                    turnA = false;
                } else {
                    return null;
                }
            } else {
                pa = pa.next;
            }
            if (pb == null) {
                if (turnB) {
                    pb = headA;
                    turnB = false;
                } else {
                    return null;
                }
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
