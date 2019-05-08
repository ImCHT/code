package bean;

//Á´±í½Úµã
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr){
        this.val = arr[0];
        ListNode temp = this;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
    }
}
