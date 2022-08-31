package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;

/**
 * @Author Slek
 * @Date 2022/8/30 22:44
 * @Description 找出连个链表的相交点
 * A遍历完了，从B开始
 * B遍历完了，从A开始
 * 如果存在相交，则必然返回值
 * 如果不存在相交（两条平行链表），最终都能够遍历到尾部（null）
 */
public class LC_160_2LinkedListMeet {


    /**
     * 其核心就是A和B 首尾链接
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
