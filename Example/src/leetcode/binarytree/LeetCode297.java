package leetcode.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
    题目描述：
    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
    同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
    你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    思路：
    1. 可以用先序遍历的方法序列化和反序列化二叉树，节点的值之间用","隔开，空节点用null表示
    2. 可以用按层遍历的方式序列化和反序列化二叉树
    不过由于和LeetCode的序列化格式不一样
    实现了两种格式的二叉树序列化和反序列化：空节点的子节点也序列化；空节点的子节点不进行序列化
    @author CHT
 */
public class LeetCode297 {
    public static void main(String[] args){
        TreeNode root = new LeetCode297().deserialize1("1");
        String serializeStr = new LeetCode297().serialize1(root);
        System.out.println(serializeStr);
    }

    /**
     * 用层数遍历的方法序列化二叉树
     * 空节点也进行序列化
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
        //将输入的字符串转化为整型数组
        String[] nodeStrArray = data.split(",");
        Integer[] intArray = new Integer[nodeStrArray.length];
        for (int i = 0; i < nodeStrArray.length; i++) {
            if (!"null".equals(nodeStrArray[i])){
                intArray[i] = Integer.parseInt(nodeStrArray[i]);
            }else {
                intArray[i] = null;
            }
        }
        //建立输入值数组对应的节点数组
        ArrayList<TreeNode> arrayList = new ArrayList<>(intArray.length);
        for (Integer i:intArray) {
            if (i!=null){
                arrayList.add(new TreeNode(i));
            }else {
                arrayList.add(null);
            }
        }
        //队列1:存放所有的节点
        LinkedList<TreeNode> linkedList = new LinkedList<>(arrayList);
        //队列2：存放这层的节点
        LinkedList<TreeNode> linkedList1 = new LinkedList<>();
        linkedList1.offerLast(linkedList.peekFirst());
        TreeNode treeNodeTop = linkedList.pollFirst();
        while (linkedList.size()!=0){
            //如果下一个要安排的节点值不为null，将左右节点连接上去
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
            }else { //如果下一要安排的节点为null,跳过
                linkedList1.pollFirst();
                linkedList.pollFirst();
                linkedList.pollFirst();
            }
        }
        return treeNodeTop;
    }

    /**
     * 用层数遍历的方法序列化二叉树
     * 空节点就不进行序列化了
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
        //把最后的null都去掉
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
        //队列1：存放所有的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //队列2：存放中间节点
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
