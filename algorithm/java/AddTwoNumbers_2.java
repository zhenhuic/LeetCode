import entity.ListNode;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers_2 {
    /**
     * 常规操作
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 复用原来的节点
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int take = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + take;
            l1.val = sum % 10;
            take = sum / 10;
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        pre.next = l1 != null ? l1 : l2;
        while (take > 0) {
            if (pre.next == null) {
                int val = take % 10;
                take = take / 10;
                pre.next = new ListNode(val);
            } else {
                int sum = pre.next.val + take;
                pre.next.val = sum % 10;
                take = sum / 10;
            }
            pre = pre.next;
        }
        return dummy.next;
    }
}
