package Selected100;


import model.ListNode;

//相交链表
public class LC_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        //两条链表到达交汇点的时候，走过的长度不一定相同
        //两条链表同时遍历，A链表遍历完则从B开始遍历，B链表遍历完就从A开始遍历
        while (curA != curB) {
            if (curA != null) {
                curA = curA.next;
            } else {
                curA = headB;        //A遍历完了，从B开始遍历
            }

            if (curB != null) {
                curB = curB.next;
            } else {
                curB = headA;        //b遍历完了，从A开始遍历
            }
        }
        return curA;

    }
}
