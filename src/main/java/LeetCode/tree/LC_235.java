package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek
 * @Date 2022/9/4 23:23
 * @Description 二叉搜索树的最近公共祖先
 */
public class LC_235 {


    /*分以下几种情况
     * 1、如果q为p的子树，则公共祖先为p
     * 2、如果p为p的子树，则公共祖先为q
     * 3、如果p和q都不为各自的子树，则公共祖先为root
     * 二叉搜索树有如下特点：左节点均小于根节点，右节点均大于根节点
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }


}
