package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek_10242202
 * @Date 2022/9/20 10:43
 * @Description: 对称的树
 */

public class LC_101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left == null && right != null) || (right == null && left != null)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
