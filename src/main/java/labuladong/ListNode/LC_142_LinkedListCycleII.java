package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;

import java.util.List;

/**
 * @Author Slek
 * @Date 2022/8/30 22:44
 * @Description 环形链表II
 * 若存在环，找出环的起点；
 * 否则返回null
 */
public class LC_142_LinkedListCycleII {

    /**
     * 快慢指针
     * 先找到相遇点meet
     * 然后同时head和meet向前移动直到相遇即为起始点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        ListNode meet = getMeetNode(head, slow, fast);
        if (null != meet) {
            slow = head;
            while (slow != meet) {
                slow = slow.next;
                meet = meet.next;
            }
        }
        return meet;
    }

    public ListNode getMeetNode(ListNode head, ListNode slow, ListNode fast) {
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
