package LeetCode.tree;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Slek
 * @Date 2022/9/20 22:47
 * @Description 从中序与后序遍历序列构造二叉树
 */
public class LC_106 {
    // 存储 inorder 中值到索引的映射
    Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 后续遍历的尾节点为root
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }


    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int rootInorderIndex = inorderMap.get(rootVal);

        int leftTreeSize = rootInorderIndex - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = build(inorder, inStart, rootInorderIndex - 1,
                postorder, postStart, postStart + leftTreeSize - 1);

        root.right = build(inorder, rootInorderIndex + 1, inEnd,
                postorder, postStart + leftTreeSize, postEnd - 1);

        return root;
    }
}
