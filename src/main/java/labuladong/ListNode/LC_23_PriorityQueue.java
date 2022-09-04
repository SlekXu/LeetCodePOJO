package labuladong.ListNode;

import model.ListNode;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Slek
 * @Date 2022/8/30 23:02
 * @Description 合并K个升序链表
 */
public class LC_23_PriorityQueue {

    /**
     * 方法1:仍然两两比较
     */
    public ListNode mergeKLists_F1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int num = lists.length;
        ListNode dummy = new ListNode(Integer.MIN_VALUE, null);
        for (int i = 0; i < num; i++) {
            dummy = merge2Lists(dummy, lists[i]);
        }
        return dummy.next;
    }

    /**
     * 方法2: 类似于归并排序
     * 采用分治+递归的思想，将大问题拆分为两个具体的小问题
     */
    public ListNode mergeKLists_F2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }

        int mid = low + (high - low) / 2;
        ListNode L1 = mergeSort(lists, low, mid);
        ListNode L2 = mergeSort(lists, mid + 1, high);  //获得了两个相对升序的链表
        return merge2Lists(L1, L2);
    }

    /**
     * 方法3:K个指针分别指向K个链表，并求Kmin
     * 优先级队列，其中按照二叉堆自动排序
     */
    public ListNode mergeKLists_F3(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            cur.next = minNode;
            cur = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }

        return dummy.next;
    }


    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
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
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode h1 = new ListNode(1);
        ListNode h1_n1 = new ListNode(4);
        ListNode h1_n2 = new ListNode(5);
        h1.next = h1_n1;
        h1_n1.next = h1_n2;
        h1_n2.next = null;

        ListNode h2 = new ListNode(1);
        ListNode h2_n1 = new ListNode(3);
        ListNode h2_n2 = new ListNode(4);
        h2.next = h2_n1;
        h2_n1.next = h2_n2;
        h2_n2.next = null;

        ListNode h3 = new ListNode(2);
        ListNode h3_n1 = new ListNode(6);
        h3.next = h3_n1;
        h3_n1.next = null;
        ListNode[] lists = new ListNode[]{h1, h2, h3};

        mergeKLists_F1(lists);

    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    @Test
    public void test2() {
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v1 - v2);        //升序
        queue.offer(3);
        queue.offer(1);
        queue.offer(5);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
