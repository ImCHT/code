package leetcode.binarytree;

import bean.TreeNode;

/*
    ��Ŀ������
    ����һ������������������ ���� ������
    ˼·��
    ����ǰ�������ʵ�֣�ǰ�����Ϊ�����ң���������Ϊ���Ҹ�����ǰ����������һ�һ�£��ٽ������������
    �Ϳ��Եõ��������
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
