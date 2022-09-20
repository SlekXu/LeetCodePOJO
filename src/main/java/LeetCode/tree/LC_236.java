package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek
 * @Date 2022/9/5 22:31
 * @Description 二叉树的最近公共祖先
 */
public class LC_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        if (leftTree == null) return rightTree;     //左子树中找不到，则返回右子树
        if (rightTree == null) return leftTree;     //右子树中找不到，则返回左子树
        return root;                                //左右子树中均能找到，则绝对为root
    }
}
