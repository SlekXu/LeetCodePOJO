package LeetCode.tree;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Slek
 * @Date 2022/9/20 22:22
 * @Description 从二叉树前序遍历和中序遍历构造二叉树
 */
public class LC_105 {

    //辅助map，用来通过值，获取在中序遍历中的索引(没有重复值)
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {                    //终止条件
            return null;
        }

        int rootVal = preorder[preStart];                  //root的值得
        int rootInorderIndex = inorderMap.get(rootVal);    //root在inorder中的索引
        int leftTreeSize = rootInorderIndex - inStart;     //左子树的大小

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, rootInorderIndex - 1);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, rootInorderIndex + 1, inEnd);
        return root;
    }
}
