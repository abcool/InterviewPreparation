class PairReverse{
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println("Original List: ");
        display(head);
        System.out.println("\n Pair reversed: ");
        head = swapPairs(head);
        display(head);

        head = new ListNode(1);
        head.next=n2;
        n2.next=n3;
        n3.next=null;
        System.out.println("\n Original List: ");
        display(head);
        System.out.println("\n Pair reversed: ");
        head = swapPairs(head);
        display(head);

        head = new ListNode(1);
        head.next=n2;
        n2.next=null;
        System.out.println("\n Original List: ");
        display(head);
        System.out.println("\n Pair reversed: ");
        head = swapPairs(head);
        display(head);

        head = new ListNode(1);
        head.next=null;
        System.out.println("\n Original List: ");
        display(head);
        System.out.println("\n Pair reversed: ");
        head = swapPairs(head);
        display(head);
        
        
        head=null;
        System.out.println("\n Original List: ");
        display(head);
        System.out.println("\n Pair reversed: ");
        head = swapPairs(head);
        display(head);
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode marker = new ListNode(0);
        marker.next=head;
        ListNode prev=marker;
        while(prev.next!=null && prev.next.next!=null){
            ListNode current = prev.next;
            ListNode next=current.next;
            //swap
            current.next=next.next;
            next.next=current;
            prev.next=next;

            prev=current;
        }
        return marker.next;
    }

    private static void display(ListNode head){
        ListNode ptr=head;
        while(ptr!=null){
            System.out.printf("| %d |->",ptr.data);
            ptr=ptr.next;
        }
    }

}

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}