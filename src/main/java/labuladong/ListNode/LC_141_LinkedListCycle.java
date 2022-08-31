package labuladong.ListNode;

import labuladong.ListNode.model.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @Author Slek
 * @Date 2022/8/30 22:43
 * @Description 环形链表
 * 判断单链表中是否有环
 */
public class LC_141_LinkedListCycle {
    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { //必须保证fast和fast.next不为空，那么fast.next.next才是有意义的
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle(head));
    }
}
