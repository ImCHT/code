package bean;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * �������ڵ�
 * @Author CHT
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * ���ݲ��������������������ķ�������������������һ���ڵ�ֵ�İ����������飬û��Ϊnull
     * @param val
     * @return
     */
    public static TreeNode buildBinaryTree(Integer[] val){
        //��������ֵ�����Ӧ�Ľڵ�����
        ArrayList<TreeNode> arrayList = new ArrayList<>(val.length);
        for (Integer i:val) {
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
}
