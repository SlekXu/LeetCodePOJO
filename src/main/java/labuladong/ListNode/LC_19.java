package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;
import org.junit.Test;

/**
 * @Author Slek
 * @Date 2022/8/30 22:45
 * @Description 删除链表的倒数第N个节点
 */
public class LC_19 {
    private ListNode fast;

    /**
     * 快慢指针
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0, head);
        while (n-- >= 0) {          //快指针先走n+1步
            if (fast == null) {     //如果此时fast为空，则说明n大于链表长度，头节点删除
                return dummy.next;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        ListNode newNode = removeNthFromEnd(head, 3);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }

    }
}
