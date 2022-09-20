package LeetCode.tree;

import model.TreeNode;

/**
 * @Author Slek
 * @Date 2022/9/20 23:10
 * @Description 将有序数组转化为高度平衡的二叉搜索树
 */
public class LC_108_BST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
