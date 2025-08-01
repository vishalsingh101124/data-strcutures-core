package main.linkedlist;

class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data=data;
    }
}
public class ReverseNodeKGroup {
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original Linked List:");
        printList(root);

        ListNode result = reverseKGroup(root, k);

        System.out.println("\nLinked List after reversing in groups of " + k + ":");
        printList(result);
    }
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head=null;
        ListNode curr=head;
        while(k-->0 && curr!=null){

            ListNode next=curr.next;
            curr.next=new_head;
            new_head=curr;
            curr=next;

        }
        return new_head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode new_head=null;
        ListNode ktail=null;

        ListNode curr=head;

        while(curr!=null){
            curr=head;
            int count=0;
            while(count<k && curr!=null){
                curr=curr.next;
                count+=1;
            }
            if(count==k){
                ListNode rev_head=reverseLinkedList(head,k);
                if(new_head==null)new_head=rev_head;
                if(ktail!=null)ktail.next=rev_head;
                ktail=head;
                head=curr;
            }
        }
        if(ktail!=null)ktail.next=head;
        if(new_head==null)return head;
        else return new_head;
    }
}
