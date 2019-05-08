package leetcode.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
    ��Ŀ������
    ���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�
    ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
    �����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼���
    ��ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
    ˼·��
    1. ��������������ķ������л��ͷ����л����������ڵ��ֵ֮����","�������սڵ���null��ʾ
    2. �����ð�������ķ�ʽ���л��ͷ����л�������
    �������ں�LeetCode�����л���ʽ��һ��
    ʵ�������ָ�ʽ�Ķ��������л��ͷ����л����սڵ���ӽڵ�Ҳ���л����սڵ���ӽڵ㲻�������л�
    @author CHT
 */
public class LeetCode297 {
    public static void main(String[] args){
        TreeNode root = new LeetCode297().deserialize1("1");
        String serializeStr = new LeetCode297().serialize1(root);
        System.out.println(serializeStr);
    }

    /**
     * �ò��������ķ������л�������
     * �սڵ�Ҳ�������л�
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offerLast(root);
        while (treeNodes.size()!=0){
            if (treeNodes.peekFirst()!=null){
                stringBuilder.append(treeNodes.peekFirst().val+",");
                treeNodes.offerLast(treeNodes.peekFirst().left);
                treeNodes.offerLast(treeNodes.peekFirst().right);
            }else {
                stringBuilder.append("null"+",");
            }
            treeNodes.pollFirst();
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    public TreeNode deserialize(String data) {
        //��������ַ���ת��Ϊ��������
        String[] nodeStrArray = data.split(",");
        Integer[] intArray = new Integer[nodeStrArray.length];
        for (int i = 0; i < nodeStrArray.length; i++) {
            if (!"null".equals(nodeStrArray[i])){
                intArray[i] = Integer.parseInt(nodeStrArray[i]);
            }else {
                intArray[i] = null;
            }
        }
        //��������ֵ�����Ӧ�Ľڵ�����
        ArrayList<TreeNode> arrayList = new ArrayList<>(intArray.length);
        for (Integer i:intArray) {
            if (i!=null){
                arrayList.add(new TreeNode(i));
            }else {
                arrayList.add(null);
            }
        }
        //����1:������еĽڵ�
        LinkedList<TreeNode> linkedList = new LinkedList<>(arrayList);
        //����2��������Ľڵ�
        LinkedList<TreeNode> linkedList1 = new LinkedList<>();
        linkedList1.offerLast(linkedList.peekFirst());
        TreeNode treeNodeTop = linkedList.pollFirst();
        while (linkedList.size()!=0){
            //�����һ��Ҫ���ŵĽڵ�ֵ��Ϊnull�������ҽڵ�������ȥ
            if (linkedList1.peekFirst()!=null){
                if (linkedList.peekFirst()!=null){
                    linkedList1.peekFirst().left = linkedList.peekFirst();
                }
                linkedList1.offerLast(linkedList.pollFirst());
                if (linkedList.peekFirst()!=null){
                    linkedList1.peekFirst().right = linkedList.peekFirst();
                }
                linkedList1.offerLast(linkedList.pollFirst());
                linkedList1.pollFirst();
            }else { //�����һҪ���ŵĽڵ�Ϊnull,����
                linkedList1.pollFirst();
                linkedList.pollFirst();
                linkedList.pollFirst();
            }
        }
        return treeNodeTop;
    }

    /**
     * �ò��������ķ������л�������
     * �սڵ�Ͳ��������л���
     * @param root
     * @return
     */
    public String serialize1(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root==null){
            return stringBuilder.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curTreeNode = queue.poll();
            if (curTreeNode!=null){
                queue.offer(curTreeNode.left);
                queue.offer(curTreeNode.right);
                stringBuilder.append(curTreeNode.val+",");
            }else {
                stringBuilder.append("null"+",");
                continue;
            }
        }
        //������null��ȥ��
        while (stringBuilder.length()>=5 && "null,".equals(stringBuilder.substring(stringBuilder.length()-5,stringBuilder.length()))){
            stringBuilder.delete(stringBuilder.length()-5,stringBuilder.length());
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }


    public TreeNode deserialize1(String data) {
        if (data==null || data.length()==0){
            return null;
        }
        String[] strings = data.split(",");
        Integer[] valNums = new Integer[strings.length];
        //����1��������еĽڵ�
        Queue<TreeNode> queue = new LinkedList<>();
        //����2������м�ڵ�
        Queue<TreeNode> curNodes = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            if ("null".equals(strings[i])){
                valNums[i] = null;
                queue.offer(null);
            }else {
                valNums[i] = Integer.parseInt(strings[i]);
                queue.offer(new TreeNode(valNums[i]));
            }
        }
        TreeNode root = queue.peek();
        curNodes.offer(queue.poll());
        while (!queue.isEmpty()){
            TreeNode curNode = curNodes.poll();
            curNode.left = queue.peek();
            if (queue.peek()!=null){
                curNodes.offer(queue.poll());
            }else {
                queue.poll();
            }
            curNode.right = queue.peek();
            if (queue.peek()!=null){
                curNodes.offer(queue.poll());
            }else {
                queue.poll();
            }
        }
        return root;
    }
}
