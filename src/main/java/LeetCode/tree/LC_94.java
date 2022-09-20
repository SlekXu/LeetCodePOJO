package LeetCode.tree;

import model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Slek
 * @Date 21:02 2022/9/17
 * @Description 二叉树的中序遍历：左中右
 */
public class LC_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;

    }
}
