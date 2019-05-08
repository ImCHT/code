package leetcode.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    题目描述：(不是很懂)
    给定一个二叉树，返回它的 中序 遍历。
    思路：
    用非递归的方法。通过循环+栈来模拟递归
 */
public class LeetCode94 {
    public static void main(String[] args){

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curTreeNode = root;
        while (curTreeNode!=null || !stack.isEmpty()){
            while (curTreeNode!=null){
                stack.push(curTreeNode);
                curTreeNode = curTreeNode.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            curTreeNode = node.right;
        }
        return list;
    }
}
