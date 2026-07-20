class SortedListInsertion{

    static Node head;

    public static void main(String[] args) {
        // 25->36->47->58->69->80
        head = new Node(25);
        Node n2 = new Node(36);
        Node n3 = new Node(47);
        Node n4 = new Node(58);
        Node n5 = new Node(69);
        Node n6 = new Node(80);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        System.out.println("Original list");
        display();
        head = sortedInsert(head, 19);
        System.out.println("Updated list after adding 19");
        display();
        // 50->100
        head = new Node(50);
        n2 = new Node(100);
        head.next=n2;
        System.out.println("Original list");
        display();
        head = sortedInsert(head, 75);
        System.out.println("Updated list after adding 75");
        display();
    }

    static Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);
        if(head==null) return newNode;
        if(key<=head.data){
            newNode.next=head;
            head=newNode;
            return head;
        }
        Node ptr1=head;
        Node ptr2=head;
        while(ptr2!=null && ptr2.data<=key){
            ptr1=ptr2;
            ptr2=ptr2.next;
        }
        newNode.next=ptr2;
        ptr1.next=newNode;
        return head;
    }

    static void display(){
        Node ptr=head;
        while(ptr!=null){
            System.out.printf("| %d |->",ptr.data);
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }

}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}