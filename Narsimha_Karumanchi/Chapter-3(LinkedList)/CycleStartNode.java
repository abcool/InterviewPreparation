class CycleStartNode{

    static ListNode head;

    public static void main(String[] args) {
        
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        System.out.println("Cycle for list 1 starts at node: "+ detectCycle(head).val);

        head= new ListNode(1);
        n2 = new ListNode(2);
        head.next=n2;
        n2.next=head;

        System.out.println("Cycle for list 2 starts at node: "+ detectCycle(head).val);


    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        boolean cycleExists=false;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr){
                cycleExists=true;
                break;
            }
        }
        if(cycleExists){
            slowPtr=head;
            while(slowPtr!=fastPtr){
                slowPtr=slowPtr.next;
                fastPtr=fastPtr.next;
            }
            return slowPtr;
        }else{
            return null;
        }
        
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}