import java.util.*;
class KthFromEnd{

    Node head;

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        var scan = new Scanner(System.in);
        System.out.println("Enter kth position");
        int pos = scan.nextInt();
        scan.close();
        System.out.printf("%d th element from end is %d \n",pos,getKthFromLast(head, pos));
    }

    private static int getKthFromLast(Node head, int pos){
        Node ptr1=head;
        Node ptr2=ptr1;
        for(int i=1;i<pos;i++){
            ptr2=ptr2.next;
            if(ptr2==null)
                return -1;
        }
        while(ptr2.next!=null){
            ptr2=ptr2.next;
            ptr1=ptr1.next;
        }
        return ptr1.data;
    }
    
}

class Node {
    int data;
    Node next;
   public Node(int val){
        this.data=val;
    }
}