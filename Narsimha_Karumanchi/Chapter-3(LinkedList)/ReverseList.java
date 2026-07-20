class ReverseList{

    static ListNode head;

    public static void main(String[] args) {

        head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next=n2;
        System.out.println("Original list:");
        display();
        System.out.println("Reversed");
        head = reverseList(head);
        display();

        head = new ListNode(1);
        n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);
        var n5 = new ListNode(5);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println("Original list:");
        display();
        System.out.println("Reversed");
        head = reverseList(head);
        display();
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    static void display(){
        ListNode ptr=head;
        while(ptr!=null){
            System.out.printf("| %d |->",ptr.data);
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }

}
class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}