package Selected100;

import model.ListNode;

public class LC_148_RE {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到分割点
        ListNode rHead = slow.next;
        slow.next = null;

        //递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(rHead);

        //合并两个相对有序的链表
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = ((left == null) ? right : left);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = getList();
        LC_148_RE obj = new LC_148_RE();

    }

    private static ListNode getList() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = null;
        return head;
    }

}
