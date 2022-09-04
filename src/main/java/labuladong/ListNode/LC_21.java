package labuladong.ListNode;

import model.ListNode;

/**
 * @Author Slek
 * @Date 2022/8/30 23:02
 * @Description 合并两个有序链表（升序）
 */
public class LC_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummyNode = new ListNode(0);   //哑节点
        ListNode cur = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null) ? list2 : list1;
        return dummyNode.next;
    }
}
