package algorithm;

import bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
��ת����3�ַ���
1. ����ָ�룬��������ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
2. �ݹ顣������һ��Ľڵ㣬����ת�������ͷ��㡣ʱ�临�Ӷ�O(n)���ռ临�Ӷ�Ӧ����O(1)
3. �Ƚ��������ջ�������У���ȡ������ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
4. һ�����ӵ�ͷ�����棬���ͷ���ŵ�β����ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
ע���ж�Ϊ�գ���ֻ��һ���ڵ�����
 */
public class LinkedListInverse {
    static ListNode newHeadListNode;
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        ListNode listNode = new ListNode(array);
        //�����������
        ArrayList<Integer> arrayList = new ArrayList<>();
        inverseTraverseListNode(listNode,arrayList);
        for (Integer i: arrayList) {
            System.out.print(i);
        }
        System.out.println();
        //��ת����,����1���ǵݹ�
//        listNode = inverseListNode1(listNode);
//        while(listNode!=null){
//            System.out.print(listNode.val);
//            listNode = listNode.next;
//        }
        //��ת��������2���ݹ�
//        inverseListNode2(listNode);
//        while (newHeadListNode!=null){
//            System.out.print(newHeadListNode.val);
//            newHeadListNode = newHeadListNode.next;
//        }
        //��ת��������3���ǵݹ�
        listNode = inverseListNode3(listNode);
        while(listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
    //�����������
    static void inverseTraverseListNode(ListNode listNode, ArrayList<Integer> arrayList){
        if(listNode.next!=null){
            inverseTraverseListNode(listNode.next,arrayList);
        }
        arrayList.add(listNode.val);
    }
    //��ת�����ǵݹ顣����1
    static ListNode inverseListNode1(ListNode listNode){
        //�ж��ǲ��ǿ��������ֻ��һ���ڵ�
        if(listNode==null || listNode.next==null){
            return listNode;
        }
        ListNode pre = listNode;
        ListNode mid = listNode.next;
        ListNode aft = mid.next;

        pre.next = null;
        while (aft!=null){
            mid.next = pre;

            pre = mid;
            mid = aft;
            aft = aft.next;
        }
        mid.next = pre;
        return mid;
    }
    //��ת�����ݹ顣����������α��淴ת���ͷ���
    static ListNode inverseListNode2(ListNode listNode){
        //�ж��ǲ��ǿ�����
        if(listNode==null){
            return  listNode;
        }
        //�ж��Ƿ��Ѿ������һ���ڵ�
        if(listNode.next==null){
            newHeadListNode = listNode;
            return listNode;
        }
        ListNode newListNode = inverseListNode2(listNode.next);
        newListNode.next = listNode;
        listNode.next = null;
        return listNode;
    }
    //��ת�����ǵݹ飬�����ջ����������
    static ListNode inverseListNode3(ListNode listNode){
        if(listNode==null || listNode.next==null){
            return listNode;
        }
        ListNode newHeadListNode = null;
        ListNode tempListNode = null;
        Stack<ListNode> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        newHeadListNode = stack.pop();
        listNode = newHeadListNode;
        while(!stack.empty()){
            tempListNode = stack.pop();
            listNode.next = tempListNode;
            listNode = tempListNode;
        }
        listNode.next = null; //û������ʱ������ѭ��
        return newHeadListNode;
    }
}
