package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek
 * @Date 2022/10/8 10:43
 * @Description 求根节点到叶子节点数字之和
 */
public class LC_129_RE {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }


    private int dfs(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) return temp;
        return dfs(root.left, temp) + dfs(root.right, temp);
    }
}
