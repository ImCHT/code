package jianzhioffer;

import bean.ListNode;

/**
 * ��ת����
 * ����˼·
 * 1. ��ָ��
 * 2. ͷ�巨����ʵҲ����ָ��
 */
public class AimAtOffer24 {
    public static void main(String[] args){
        ListNode head = new ListNode(new int[]{1,2,3});
        ListNode tempHead = head;
        while (tempHead!=null){
            System.out.println(tempHead.val);
            tempHead = tempHead.next;
        }
        head = new AimAtOffer24().ReverseList1(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    //��ָ��
    public ListNode ReverseList(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode now = pre.next;
        ListNode aft = now.next;
        head.next = null;
        while (true){
            now.next = pre;
            if (aft!=null){
                pre = now;
                now = aft;
                aft = aft.next;
            }else {
                break;
            }
        }
        return now;
    }
    //ͷ�巨
    public ListNode ReverseList1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode now = head;
        ListNode next = now.next;
        while (true){
            now.next = newHead.next;
            newHead.next = now;
            if (next!=null){
                now = next;
                next = next.next;
            }else {
                break;
            }
        }
        return newHead.next;
    }
}
