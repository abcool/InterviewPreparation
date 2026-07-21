class LLMiddle{
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);
        var n5 = new ListNode(5);
        var n6 = new ListNode(6);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println("Middle of 1->2>3>4>5->NULL is :"+ middleNode(head).data);
        n5.next=n6;
        System.out.println("Middle of 1->2>3>4>5->6->NULL is :"+ middleNode(head).data);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }
}

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}