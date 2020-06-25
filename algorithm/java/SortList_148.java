import entity.ListNode;

/**
 * 148. 排序链表
 */
public class SortList_148 {
    /**
     * 归并排序
     * 根据时间复杂度我们自然想到二分法，从而联想到归并排序；
     * 通过递归实现链表归并排序，有以下两个环节：
     * 1. 分割 cut 环节： 找到当前链表中点，并从中点将链表断开
     * （以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，
     * 偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和
     * 中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件：当 head.next == None 时，
     * 说明只有一个节点了，直接返回此节点。
     * 2. 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助 ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，
     * 由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode curr = new ListNode(0);
        ListNode ret = curr;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return ret.next;
    }
}
