package exam.xiecheng;

import java.util.*;
//4月8号
//判断链表是否有环，先建个链表
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strings = str.split(",");
        if (strings.length==1){
            System.out.println(false);
        }else if(str.length()==2){
            if (strings[0].equals(strings[1])){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }
        //先构建链表,链表节点的值都不一样
        ListNode listNodeHead = new ListNode(strings[0]);
        ListNode listNode = listNodeHead;
        for (int i = 1; i < strings.length-1; i++) {
            listNode.next = new ListNode(strings[i]);
            listNode = listNode.next;
        }
        ListNode listNodeTail = listNode;
        listNode = listNodeHead;
        for (int i = 0; i < strings.length-1; i++) {
            if (strings[strings.length-1]==listNode.val){
                listNodeTail.next = listNode;
            }
        }
        //快慢指针判断链表是否存在环
        boolean hasCycle = false;
        ListNode fastNode = listNodeHead;
        ListNode slowNode = listNodeHead;
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
        System.out.println(hasCycle);
    }
}
class ListNode {
    public String val;
    public ListNode next = null;

    public ListNode(String val) {
        this.val = val;
    }
}


/*
//判断单链表是否有环
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char last = str.charAt(str.length()-1);
        str = str.substring(0,str.length()-1);
        System.out.println(str.indexOf(last)!=-1);
    }
}
 */
