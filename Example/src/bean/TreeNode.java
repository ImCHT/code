package bean;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树节点
 * @Author CHT
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * 根据层序遍历，广度优先搜索的方法建立二叉树。输入一个节点值的按层排列数组，没有为null
     * @param val
     * @return
     */
    public static TreeNode buildBinaryTree(Integer[] val){
        //建立输入值数组对应的节点数组
        ArrayList<TreeNode> arrayList = new ArrayList<>(val.length);
        for (Integer i:val) {
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
}
