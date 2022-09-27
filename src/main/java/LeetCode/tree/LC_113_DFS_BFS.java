package LeetCode.tree;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Slek
 * @Date 2022/9/24 14:58
 * @Description 二叉树的路径总和II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class LC_113_DFS_BFS {

    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 当遍历到叶子节点后的空节点，则返回
     * 创建一个双端队列，用于存放结果；如果遍历到叶子节点发现不符合，则弹出队尾(回溯)，将该叶子节点的兄弟节点（如果存在的话）放入
     */
    public List<List<Integer>> pathSumDFS(TreeNode root, int targetSum) {
        DFS(root, targetSum);
        return res;
    }

    private void DFS(TreeNode root, int targetSum) {
        if (root == null) return;

        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {    //叶子节点，且结果符合
            res.add(new LinkedList<>(path));
        }
        DFS(root.left, targetSum);
        DFS(root.right, targetSum);
        path.pollLast();    //一定要将本次的节点弹出，这样就可以开始遍历其右兄弟了(回溯)
    }

    /**
     * 广度优先遍历
     */
    public List<List<Integer>> pathSumBFS(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }


        Queue<TreeNode> nodeQueue = new LinkedList<>();             //存放节点队列
        Queue<List<Integer>> pathQueue = new LinkedList<>();        //存放路径队列
        nodeQueue.add(root);
        pathQueue.add(new LinkedList<Integer>() {{
            add(root.val);
        }});

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            List<Integer> tmpPath = pathQueue.poll();
            if (node.left == null && node.right == null && node.val == targetSum) {
                res.add(tmpPath);
            }

            if (node.left != null) {
                tmpPath.add(node.left.val);
                pathQueue.offer(new LinkedList<>(tmpPath));  //左路径入队
                node.left.val += node.val;  //将当前节点的值，累加到左子节点上
                nodeQueue.offer(node.left); //左子节点入队

                tmpPath.remove(tmpPath.size() - 1); //TODO 不理解
            }

            if (node.right != null) {
                tmpPath.add(node.right.val);
                pathQueue.offer(new LinkedList<>(tmpPath));
                node.right.val = node.val;
                nodeQueue.offer(node.right);
            }
        }
        return res;
    }


}
