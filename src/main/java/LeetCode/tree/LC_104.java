package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek_10242202
 * @Date 2022/9/20 19:22
 * @Description: 二叉树的最大深度
 */

public class LC_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int LEFT = maxDepth(root.left);
        int RIGHT = maxDepth(root.right);
        return Math.max(LEFT, RIGHT) + 1;

    }


}
