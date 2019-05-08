package leetcode.doublepointer;

import bean.ListNode;

/*
    ע��㣺
    ����ָ�룬����ÿ��Ҫ����next����ʱ��Ҫ���жϽڵ��Ƿ�Ϊnull
    if (slowNode != null && fastNode != null && fastNode.next != null) {
        slowNode = slowNode.next;
        fastNode = fastNode.next.next;
    }
    ��Ŀ������
    ����һ�������ж��������Ƿ��л���
    ˼·��
    ˫ָ�룬һ��һ����������һ��һ����һ���������������ˣ�˵���л�
 */
public class LeetCode141 {
    public static void main(String[] args){

    }
    public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode fastNode = head;
            ListNode slowNode = head;
            while (true) {
                if (slowNode != null && fastNode != null && fastNode.next != null) {
                    slowNode = slowNode.next;
                    fastNode = fastNode.next.next;
                } else {
                    return false;
                }
                if (slowNode == fastNode) {
                    return true;
                }
            }
        }
}
