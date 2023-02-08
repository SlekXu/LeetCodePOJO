package GS3Y.HighFrequency;

import model.ListNode;

/**
 * @Author Slek
 * @Date 2022/11/17 22:52
 * @Description LeetCode 24.两两交换链表中的节点
 * 技巧总结：启用一个哨兵作为头结点
 */
public class HF_03 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;

        }
        return null;
    }
}
