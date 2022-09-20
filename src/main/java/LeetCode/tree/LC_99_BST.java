package LeetCode.tree;


import model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Slek_10242202
 * @Date 2022/9/19 16:50
 * @Description: 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树
 */

public class LC_99_BST {


    /**
     * 二叉搜索树的中序遍历是递增的，只要保证是个递增序列
     * 找到两个发生递减的索引，然后交换即可
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();

        inOrder(root, nodeList);

        TreeNode x = null;
        TreeNode y = null;

        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).val > nodeList.get(i + 1).val) {    //出现递减
                if (x == null) {
                    x = nodeList.get(i);
                }
                y = nodeList.get(i + 1);
            }
        }

        if (x != null && y != null) {
            int tmpVal = x.val;
            x.val = y.val;
            y.val = tmpVal;
        }
//        for (TreeNode node : nodeList) {
//            System.out.print(node.val + " ");
//        }

    }


    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);

    }

/*    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(2);
        TreeNode left_l = new TreeNode(1);
        TreeNode left_r = new TreeNode(3);
        TreeNode right_l = new TreeNode(6);
        TreeNode right_r = new TreeNode(8);
        root.left = left;
        root.right = right;
        left.left = left_l;
        left.right = left_r;
        right.left = right_l;
        right.right = right_r;
        left_l.left = null;
        left_l.right = null;
        left_r.left = null;
        left_r.right = null;
        right_l.left = null;
        right_l.right = null;
        right_r.left = null;
        right_r.right = null;
        recoverTree(root);
    }*/

}
