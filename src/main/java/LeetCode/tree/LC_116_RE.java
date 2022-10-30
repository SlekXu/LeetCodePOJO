package LeetCode.tree;

import model.Node;

/**
 * @Author Slek
 * @Date 2022/9/27 22:58
 * @Description 填充每个节点的下一个右侧节点指针(类似于三叉树)
 */
public class LC_116_RE {


    public Node connect(Node root) {
        if (root == null) return root;
        traverse(root.left, root.right);
        return root;
    }


    private void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;

        //将传入的两个节点连起来
        node1.next = node2;

        //将传入的两个节点下的子节点连起来
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        //将跨父节点的两个子节点连起来
        traverse(node1.right, node2.left);

    }
}
