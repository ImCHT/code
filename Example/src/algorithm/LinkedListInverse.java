package algorithm;

import bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
反转链表3种方法
1. 三个指针，遍历链表。时间复杂度O(n),空间复杂度O(1)
2. 递归。返回下一层的节点，即反转后链表的头结点。时间复杂度O(n)，空间复杂度应该是O(1)
3. 先将链表放入栈或数组中，再取出来。时间复杂度O(n)，空间复杂度O(n)
4. 一个个接到头结点后面，最后将头结点放到尾部。时间复杂度O(n),空间复杂度O(1)
注意判断为空，或只有一个节点的情况
 */
public class LinkedListInverse {
    static ListNode newHeadListNode;
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        ListNode listNode = new ListNode(array);
        //反向遍历链表
        ArrayList<Integer> arrayList = new ArrayList<>();
        inverseTraverseListNode(listNode,arrayList);
        for (Integer i: arrayList) {
            System.out.print(i);
        }
        System.out.println();
        //反转链表,方法1，非递归
//        listNode = inverseListNode1(listNode);
//        while(listNode!=null){
//            System.out.print(listNode.val);
//            listNode = listNode.next;
//        }
        //反转链表，方法2，递归
//        inverseListNode2(listNode);
//        while (newHeadListNode!=null){
//            System.out.print(newHeadListNode.val);
//            newHeadListNode = newHeadListNode.next;
//        }
        //反转链表，方法3，非递归
        listNode = inverseListNode3(listNode);
        while(listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
    //反向遍历链表
    static void inverseTraverseListNode(ListNode listNode, ArrayList<Integer> arrayList){
        if(listNode.next!=null){
            inverseTraverseListNode(listNode.next,arrayList);
        }
        arrayList.add(listNode.val);
    }
    //反转链表，非递归。方法1
    static ListNode inverseListNode1(ListNode listNode){
        //判断是不是空链表或者只有一个节点
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
    //反转链表，递归。方法二。如何保存反转后的头结点
    static ListNode inverseListNode2(ListNode listNode){
        //判断是不是空链表
        if(listNode==null){
            return  listNode;
        }
        //判断是否已经到最后一个节点
        if(listNode.next==null){
            newHeadListNode = listNode;
            return listNode;
        }
        ListNode newListNode = inverseListNode2(listNode.next);
        newListNode.next = listNode;
        listNode.next = null;
        return listNode;
    }
    //反转链表，非递归，数组或栈。方法三。
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
        listNode.next = null; //没这句遍历时会无限循环
        return newHeadListNode;
    }
}
