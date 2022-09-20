package LeetCode.tree;

import model.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author Slek_10242202
 * @Date 2022/9/20 16:09
 * @Description: 二叉树的锯齿形遍历(之字打印)
 */

public class LC_103_BFS {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        boolean turn = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (turn) {
                Collections.reverse(level);
            }
            res.add(level);
            turn = !turn;
        }
        System.out.println(res);
        return res;
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
        zigzagLevelOrder(root);
    }*/
}
