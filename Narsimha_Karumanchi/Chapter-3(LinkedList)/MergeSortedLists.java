class MergeSortedLists{

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        var n2 = new ListNode(2);
        var n4 = new ListNode(4);

        list1.next=n2;
        n2.next=n4;

        System.out.println("List 1: ");
        printList(list1);

        ListNode list2 = new ListNode(1);
        var n3 = new ListNode(3);
        var n4_2 = new ListNode(4);
        list2.next=n3;
        n3.next=n4_2;
        System.out.println("List 2: ");
        printList(list2);

        System.out.println("Merged list: ");
        printList(mergeTwoLists(list1, list2));

        System.out.println("List 1: ");
        printList(null);

        System.out.println("List 2: ");
        printList(new ListNode(0));

        System.out.println("Merged list: ");
        printList(mergeTwoLists(null, new ListNode(0)));

        

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head= new ListNode();
        ListNode ptr=head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                ptr.next=list1;
                list1=list1.next;
            }else if(list1.val>list2.val){
                ptr.next=list2;
                list2=list2.next;
            }
            ptr=ptr.next;
        }
        if(list1!=null){
            ptr.next=list1;
        }
        if(list2!=null){
            ptr.next=list2;
        }
        head = head.next;
        return head;
    }

    private static void printList(ListNode head){
        ListNode ptr=head;
        while(ptr!=null){
            System.out.printf("| %d |-> ",ptr.val);
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(){}
}