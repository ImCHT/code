package leetcode.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    题目描述：
    给定一个二叉树，返回它的 前序 遍历。
    思路：
    用非递归的方法。通过循环+栈来模拟递归
 */
public class LeetCode144 {
    public static void main(String[] args){
        TreeNode root = TreeNode.buildBinaryTree(new Integer[]{1,2,3,6,7,4,5,null,9,8,null});
        List<Integer> list = new LeetCode144().preorderTraversal(root);
        for (Integer i:list
             ) {
            System.out.println(i);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curTreeNode = stack.pop();
            if (curTreeNode==null){
                continue;
            }
            list.add(curTreeNode.val);
            stack.push(curTreeNode.right);
            stack.push(curTreeNode.left);
        }
        return list;
    }
}
