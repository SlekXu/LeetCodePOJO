package labuladong.ListNode.model;

/**
 * @Author Slek
 * @Date 2022/8/30 23:07
 * @Description TODO
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}