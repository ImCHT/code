package leetcode.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    ��Ŀ������(���Ǻܶ�)
    ����һ������������������ ���� ������
    ˼·��
    �÷ǵݹ�ķ�����ͨ��ѭ��+ջ��ģ��ݹ�
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
