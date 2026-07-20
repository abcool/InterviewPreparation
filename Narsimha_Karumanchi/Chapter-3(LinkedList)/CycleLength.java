class CycleLength{
    static Node head;
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n2;
        System.out.println("Length of loop in list 1: "+ lengthOfLoop(head));
        n1 = new Node(25);
        n2 = new Node(14);
        n3 = new Node(19);
        n4 = new Node(33);
        n5 = new Node(10);
        head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n3;
        System.out.println("Length of loop in list 2: "+ lengthOfLoop(head));
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n5 = new Node(5);
        head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println("Length of loop in list 3: "+ lengthOfLoop(head));
    }

    public static int lengthOfLoop(Node head) {
        // code here
        Node slowPtr=head;
        Node fastPtr=head;
        boolean cycleExists=false;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr){
                cycleExists=true;
                break;
            }
        }
        int length=0;
        if(cycleExists){
            length=1;
            slowPtr=slowPtr.next;
            while(slowPtr!=fastPtr){
                length++;
                slowPtr=slowPtr.next;
            }
        }
        return length;
    }

}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}