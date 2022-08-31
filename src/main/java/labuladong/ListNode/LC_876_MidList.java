package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;

/**
 * @Author Slek
 * @Date 2022/8/30 23:03
 * @Description 返回非空链表的中间节点
 */
public class LC_876_MidList {

    /**
     * 快慢指针
     * 小技巧，让slow和fast从哑节点开始遍历，
     * 中间节点即为slow节点(fast!=null&&fast.next!=null)
     * 当然根据题目需要区分奇偶性
     */
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (fast == null) ? slow : slow.next;
    }
}
