import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个排序链表
 */
public class MergeKSortedLists_23 {
    /**
     * 小顶堆
     */
    public ListNode mergeKListsHeap(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

    /**
     * 分而治之
     */
    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 递归分治
     * 归并排序变种
     */
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode head = new ListNode(0), tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
