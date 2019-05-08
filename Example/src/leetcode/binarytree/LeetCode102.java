package leetcode.binarytree;

/*
    题目描述：
    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    思路：
    广度优先搜索
 */
import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public static void main(String[] args){

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        //特殊情况
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
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
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }

}
