package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek_10242202
 * @Date 2022/9/20 10:33
 * @Description: 相同的树
 */

public class LC_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
