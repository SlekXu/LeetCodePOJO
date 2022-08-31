package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;

/**
 * @Author Slek
 * @Date 2022/8/30 23:03
 * @Description 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class LC_86 {
    /**
     * 分别用两条链表记录 小于X和 大于等于X的值
     * 然后将大小链表连起来即可
     **/
    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode cur1 = low, cur2 = high;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = high.next;
        cur2.next = null;
        return low.next;
    }
}
