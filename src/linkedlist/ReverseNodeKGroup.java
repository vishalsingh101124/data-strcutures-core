package linkedlist;

class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data=data;
    }
}
public class ReverseNodeKGroup {
    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(5);
        reverseKGroup(root,2);

    }
    public static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;
            ptr = next_node;
            k--;
        }
         return new_head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;

        ListNode new_head = null;

        while (ptr != null) {
            int count = 0;

            ptr = head;

            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                if (new_head == null) new_head = revHead;
                if (ktail != null) ktail.next = revHead;
                ktail = head;
                head = ptr;
            }
        }

        if (ktail != null) ktail.next = head;

        return new_head == null ? head : new_head;
    }
}
