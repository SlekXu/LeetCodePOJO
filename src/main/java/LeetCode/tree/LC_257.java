package LeetCode.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Slek
 * @Date 2022/9/20 23:48
 * @Description 深度优先搜索or广度优先搜素
 */
public class LC_257 {

    /**
     * 如果是叶子节点则加入结果集
     * 如果不是叶子节点则递归查找
     */
    public List<String> binaryTreePathsDFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPath(root, "", paths);
        return paths;
    }

    private void constructPath(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            StringBuffer tmpPath = new StringBuffer(path);
            tmpPath.append(node.val);
            if (node.left == null && node.right == null) {  //叶子节点
                paths.add(tmpPath.toString());
            } else {
                tmpPath.append("->");
                constructPath(node.left, tmpPath.toString(), paths);
                constructPath(node.right, tmpPath.toString(), paths);
            }
        }
    }

    /**
     * 层序遍历，主要培养迭代意识
     */
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>(); //node和path是一一对应的
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String tmpPath = pathQueue.poll();
            if (node.left == null && node.right == null) {  //叶子节点
                paths.add(tmpPath);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    StringBuffer pathSB = new StringBuffer();
                    pathSB.append(tmpPath).append("->").append(node.left.val);
                    pathQueue.offer(pathSB.toString());
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    StringBuffer pathSB = new StringBuffer();
                    pathSB.append(tmpPath).append("->").append(node.right.val);
                    pathQueue.offer(pathSB.toString());
                }
            }
        }
        return paths;
    }
}
