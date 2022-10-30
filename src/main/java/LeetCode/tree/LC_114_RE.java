package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek
 * @Date 2022/9/27 22:38
 * @Description 将二叉树展开为链表(原地)
 */
public class LC_114_RE {

    /**
     * 首先把左、右子树拉平
     * 然后把右子树接到左子树上
     * 然后把整个左子树作为右子树
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        //1、将左右子树拉平
        flatten(root.left);
        flatten(root.right);

        TreeNode LEFT = root.left;
        TreeNode RIGHT = root.right;

        //2、将左子树变成右子树
        root.left = null;
        root.right = LEFT;

        //3、将原来的右子树，接到现在右子树(原本的左子树)的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = RIGHT;

    }
}
