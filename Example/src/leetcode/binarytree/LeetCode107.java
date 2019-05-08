package leetcode.binarytree;

/*
    题目描述：
    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    思路：
    bfs层次遍历，每次新层的数据插在最前面
 */
import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {
    public static void main(String[] args){

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        //特殊情况
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode tempTreeNode = queue.poll();
                if (tempTreeNode.left!=null){
                    queue.add(tempTreeNode.left);
                }
                if (tempTreeNode.right!=null){
                    queue.add(tempTreeNode.right);
                }
                list.add(tempTreeNode.val);
            }
            lists.add(0,new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
