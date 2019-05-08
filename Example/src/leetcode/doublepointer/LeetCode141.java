package leetcode.doublepointer;

import bean.ListNode;

/*
    注意点：
    快慢指针，链表每次要进行next操作时，要先判断节点是否为null
    if (slowNode != null && fastNode != null && fastNode.next != null) {
        slowNode = slowNode.next;
        fastNode = fastNode.next.next;
    }
    题目描述：
    给定一个链表，判断链表中是否有环。
    思路：
    双指针，一个一次走两步，一个一次走一步，如果最后相遇了，说明有环
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
