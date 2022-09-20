package LeetCode.tree;

import model.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Slek_10242202
 * @Date 2022/9/20 10:56
 * @Description: 二叉树的层序遍历
 */

public class LC_102_BFS {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();               //当前该层包含的节点数
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println(level);
            res.add(level);
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
        levelOrder(root);
    }*/
}
