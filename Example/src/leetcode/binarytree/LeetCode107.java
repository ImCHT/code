package leetcode.binarytree;

/*
    ��Ŀ������
    ����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
    ˼·��
    bfs��α�����ÿ���²�����ݲ�����ǰ��
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
        //�������
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