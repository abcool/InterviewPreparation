class DetectCycle{
    public static void main(String[] args) {
        Node[] head = new Node[5];
        System.out.println("Does cycle exist: "+ detectCycle(head[0]));
        for(int i=0;i<5;i++){
            head[i]=new Node(i);
        }
        for(int i=0;i<4;i++){
            head[i].next=head[i+1];
        }
        head[4].next=head[0];
        System.out.println("Does cycle exist: "+ detectCycle(head[0]));
        head[1].next=null;
        System.out.println("Does cycle exist: "+ detectCycle(head[0]));
    }
    private static boolean detectCycle(Node head){
        Node slowPtr=head;
        Node fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr)
                return true;
        }
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