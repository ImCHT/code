package leetcode.binarytree;

import bean.TreeNode;

/*
    题目描述：
    给定一个二叉树，返回它的 后序 遍历。
    思路：
    利用前序遍历来实现，前序遍历为根左右，后续遍历为左右根，将前序遍历的左右换一下，再将遍历结果逆序，
    就可以得到后序遍历
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {
    public static void main(String[] args){

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curTreeNode = stack.pop();
            if (curTreeNode==null){
                continue;
            }
            list.add(curTreeNode.val);
            stack.push(curTreeNode.left);
            stack.push(curTreeNode.right);
        }
        Collections.reverse(list);
        return list;
    }
}
