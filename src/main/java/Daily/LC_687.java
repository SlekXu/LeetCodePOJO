package Daily;


import model.TreeNode;

import java.util.Deque;

/**
 * @Author Slek
 * @Date 2022/9/2 22:49
 * @Description TODO
 */
public class LC_687 {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        DFS(root);
        return res;
    }


    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //找到左右的 最长同值 子树长度
        int LEFT = DFS(root.left);
        int RIGHT = DFS(root.right);

        //具体的子问题
        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {   //假设左边有节点，且节点值等于根节点
            left = LEFT + 1;
        }
        if (root.right != null && root.right.val == root.val) { //假设右边有节点，且节点值等于根节点
            right = RIGHT + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);   //需要返回最长同值 子树长度
    }
}
