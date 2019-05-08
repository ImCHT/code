package interview;

import bean.ListNode;

import java.util.ArrayList;

/**
 * �����л��ĵ�����ĸ���
 */
public class ALi0403 {
    public static void main(String[] args){
        //�����л�����
        ListNode head = new ListNode(1);
        ListNode temp = head;
        ListNode headOfCycle = new ListNode(2);
        temp.next = headOfCycle;
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = headOfCycle;

        ListNode newListNode = copyOfLinkedList1(head);
        //�л�ʱ����
        for (int i = 0; i < 5; i++) {
            System.out.println(newListNode.val);
            newListNode = newListNode.next;
        }
    }
    //��û�ڻ��е�������ΪN���ڻ��е�������ΪM����Ҫ��N+[M-(N%M)]��������ָ�������
    //O(n)���������㷨
    static ListNode copyOfLinkedList1(ListNode listNode){
        //�쳣����ж�
        if (listNode==null){
            return null;
        }
        //��һ�����ж��Ƿ���ڻ�
        boolean hasCycle = false;
        ListNode newListNode = new ListNode(listNode.val);
        ListNode fastNode = listNode;
        ListNode slowNode = listNode;
        while (true){
            if (slowNode != null && fastNode != null && fastNode.next != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            } else {
                hasCycle = false;
                break;
            }
            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }
        //���ڻ�
        if (hasCycle){
            //�ڶ�����������ĳ���
            int lengthOfCycle = 1;
            fastNode = fastNode.next;
            while (fastNode!=slowNode){
                fastNode = fastNode.next;
                lengthOfCycle++;
            }
            //���������õ�������ڽ�㡣��õ�����ĵ�����n����㷽����ͬ
            fastNode = listNode;
            slowNode = listNode;
            for (int i = 0; i < lengthOfCycle; i++) {
                fastNode = fastNode.next;
            }
            while (fastNode!=slowNode){
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
            //���Ĳ������ݻ�����ڽڵ���и���
            ListNode tempNewListNode = newListNode;
            ListNode tempListNode = listNode;
            //���ƻ��ⲿ��
            while (tempListNode!=fastNode){
                tempNewListNode.next = new ListNode(tempListNode.next.val);
                tempListNode = tempListNode.next;
                tempNewListNode = tempNewListNode.next;
            }
            //���ƻ�
            ListNode newListNodeHeadOfCycle = tempNewListNode;
            while (tempListNode.next!=fastNode){
                tempNewListNode.next = new ListNode(tempListNode.next.val);
                tempListNode = tempListNode.next;
                tempNewListNode = tempNewListNode.next;
            }
            tempNewListNode.next = newListNodeHeadOfCycle;
        }else { //�����ڻ�
            while (listNode!=null){
                newListNode.next = new ListNode(listNode.next.val);
                listNode = listNode.next;
                newListNode = newListNode.next;
            }
        }

        return newListNode;
    }

    //O(n2)���������㷨
    static ListNode copyOfLinkedList2(ListNode listNode){
        if(listNode==null){
            return null;
        }
        ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
        ListNode newListNode = new ListNode(listNode.val);
        ListNode srcListNode = listNode;
        arrayList.add(srcListNode);
        ListNode tempListNode = newListNode;
        //�ж��Ƿ�β�ڵ㣬���ߵ��˻��Ŀ�ʼ�ڵ�
        while(listNode.next!=null && (isLoopNode(arrayList,listNode.next)==-1) ){
            tempListNode.next = new ListNode(listNode.next.val);
            tempListNode = tempListNode.next;
            listNode = listNode.next;
            arrayList.add(listNode);
        }
        ListNode newListNode1 = newListNode;
        //���������-1��˵�����ڻ����ҷ����˻���ʼ�ڵ�����
        if(isLoopNode(arrayList,listNode.next)!=-1){
            int i = isLoopNode(arrayList,listNode.next);
            for(int j=0;j<i;j++){
                newListNode1 = newListNode1.next;
            }
            tempListNode.next = newListNode1;
        }
        return newListNode;
    }
    //�ж���һ�ڵ��Ƿ��ǻ���ʼ�ڵ㣬���Ƿ��ػ���ʼ�ڵ�����
    static int isLoopNode(ArrayList<ListNode> arrayList,ListNode listNode){
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i)==listNode){
                return i;
            }
        }
        //�����ڻ�
        return -1;
    }
}

