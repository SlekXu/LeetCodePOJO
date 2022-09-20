package LeetCode.tree;

import model.TreeNode;

import java.util.*;

/**
 * @Author Slek
 * @Date 2022/9/20 22:58
 * @Description 二叉树的层序遍历II
 */
public class LC_107_BFS {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

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
            res.add(0, level);  //每次都将当前层的结果塞到LinkedList的头部
        }
        return res;
    }
}
