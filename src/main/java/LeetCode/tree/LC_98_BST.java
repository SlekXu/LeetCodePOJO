package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek_10242202
 * @Date 2022/9/19 15:12
 * @Description: 验证二叉搜索树
 * 二叉搜索树：如果某个节点存在左树，则左树上的所有节点的值均小于该节点；若存在右树，则右树上的所有节点的值均大于该节点
 * 中序遍历是递增的
 */

public class LC_98_BST {

    /**
     * 不能简单得用递归实现，因为哪怕局部子树的结构符合，整体结构也不一定符合：因为你无法将上一次递归的上/下边界带进来
     * 比如：5,4,6,null,null,3,7  局部校验都是满足的，但是实际上这不是一课BST
     * 所以需要在递归遍历的时候将一次的上下边界带进来——使用额外的函数实现
     */
    public boolean isValidBST(TreeNode root) {
        return preOrderCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    //类似于前序遍历
    private boolean preOrderCheck(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return preOrderCheck(root.left, lower, root.val) && preOrderCheck(root.right, root.val, upper);
    }


    //二叉树的中序遍历是递增的
    Long preNodeVal = Long.MIN_VALUE;

    public boolean InOrderCheck(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!InOrderCheck(root.left)) {
            return false;
        }

        if (root.val <= preNodeVal) {
            return false;
        }
        preNodeVal = (long) root.val;

        return InOrderCheck(root.right);
    }


}
