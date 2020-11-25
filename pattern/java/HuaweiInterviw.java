public class HuaweiInterview {
    ListNode cur;
    ListNode ret = new ListNode(0);
    ListNode dummy = ret;
    int num = 0;
    int cnt = 0;
    public ListNode convert(ListNode head) {
        cur = head;
        recur(head);
        ret.next = null;
        return dummy.next;
    }

    public void recur(ListNode node) {
        if (node != null) {
            num++;
            recur(node.next);
            if (cnt < num) {
                ret.next = cur;
                cur = cur.next;
                ret = ret.next;
                cnt++;
                if (cnt < num) {
                    ret.next = node;
                    ret = node;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) {
        HuaweiInterview test2 = new HuaweiInterview();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ret = test2.convert(head);

        while (ret != null) {
            System.out.print(ret.val + " ");
            ret = ret.next;
        }

    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


}
