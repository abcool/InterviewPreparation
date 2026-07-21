class EvenOddList{
    static Node head;
    public static void main(String[] args) {
        head = new Node(1);
        System.out.println("List 1 is even length: "+ isEven(head));
        Node n2 = new Node(2);
        head.next=n2;
        System.out.println("List 2 is even length: "+ isEven(head));
        Node n3 = new Node(3);
        n2.next=n3;
        System.out.println("List 3 is even length: "+ isEven(head));
    }


    private static boolean isEven(Node head){
        Node ptr=head;
        while(ptr!=null && ptr.next!=null){
            ptr=ptr.next.next;
        }
        if(ptr==null)
            return true;
        else
            return false;
    }

}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}