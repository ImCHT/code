package interview;

import bean.ListNode;

import java.util.ArrayList;

/**
 * 可能有环的单链表的复制
 */
public class ALi0403 {
    public static void main(String[] args){
        //创建有环链表
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
        //有环时遍历
        for (int i = 0; i < 5; i++) {
            System.out.println(newListNode.val);
            newListNode = newListNode.next;
        }
    }
    //设没在环中的链表长度为N，在环中的链表长度为M，需要走N+[M-(N%M)]步，快慢指针会相遇
    //O(n)的链表复制算法
    static ListNode copyOfLinkedList1(ListNode listNode){
        //异常情况判断
        if (listNode==null){
            return null;
        }
        //第一步：判断是否存在环
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
        //存在环
        if (hasCycle){
            //第二步：算出环的长度
            int lengthOfCycle = 1;
            fastNode = fastNode.next;
            while (fastNode!=slowNode){
                fastNode = fastNode.next;
                lengthOfCycle++;
            }
            //第三步：得到环的入口结点。与得到链表的倒数第n个结点方法相同
            fastNode = listNode;
            slowNode = listNode;
            for (int i = 0; i < lengthOfCycle; i++) {
                fastNode = fastNode.next;
            }
            while (fastNode!=slowNode){
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
            //第四步：根据环的入口节点进行复制
            ListNode tempNewListNode = newListNode;
            ListNode tempListNode = listNode;
            //复制环外部分
            while (tempListNode!=fastNode){
                tempNewListNode.next = new ListNode(tempListNode.next.val);
                tempListNode = tempListNode.next;
                tempNewListNode = tempNewListNode.next;
            }
            //复制环
            ListNode newListNodeHeadOfCycle = tempNewListNode;
            while (tempListNode.next!=fastNode){
                tempNewListNode.next = new ListNode(tempListNode.next.val);
                tempListNode = tempListNode.next;
                tempNewListNode = tempNewListNode.next;
            }
            tempNewListNode.next = newListNodeHeadOfCycle;
        }else { //不存在环
            while (listNode!=null){
                newListNode.next = new ListNode(listNode.next.val);
                listNode = listNode.next;
                newListNode = newListNode.next;
            }
        }

        return newListNode;
    }

    //O(n2)的链表复制算法
    static ListNode copyOfLinkedList2(ListNode listNode){
        if(listNode==null){
            return null;
        }
        ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
        ListNode newListNode = new ListNode(listNode.val);
        ListNode srcListNode = listNode;
        arrayList.add(srcListNode);
        ListNode tempListNode = newListNode;
        //判断是否到尾节点，或者到了环的开始节点
        while(listNode.next!=null && (isLoopNode(arrayList,listNode.next)==-1) ){
            tempListNode.next = new ListNode(listNode.next.val);
            tempListNode = tempListNode.next;
            listNode = listNode.next;
            arrayList.add(listNode);
        }
        ListNode newListNode1 = newListNode;
        //如果不等于-1，说明存在环，且返回了环开始节点的序号
        if(isLoopNode(arrayList,listNode.next)!=-1){
            int i = isLoopNode(arrayList,listNode.next);
            for(int j=0;j<i;j++){
                newListNode1 = newListNode1.next;
            }
            tempListNode.next = newListNode1;
        }
        return newListNode;
    }
    //判断下一节点是否是环开始节点，若是返回环开始节点的序号
    static int isLoopNode(ArrayList<ListNode> arrayList,ListNode listNode){
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i)==listNode){
                return i;
            }
        }
        //不存在环
        return -1;
    }
}

