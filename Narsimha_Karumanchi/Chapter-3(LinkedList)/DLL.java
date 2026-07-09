import java.util.*;
class DLL{
    static DLLNode head=null;
    static int length=0;
    public static void main(String[] args) {
        try(var scan = new Scanner(System.in)){
        boolean flag=true;
        while(flag){
        System.out.println("\n Select operation");
        System.out.println("1. Add element at starting");
        System.out.println("2. Add element to end");
        System.out.println("3. Add element at position");
        System.out.println("4. Display LL");
        System.out.println("5. Delete element from beginning");
        System.out.println("6. Delete element from end");
        System.out.println("7. Delete element at position");
        System.out.println("8. Size of list");
        System.out.println("9. Return position of first match of input value");
        System.out.println("10. Reverse a linked list");
        System.out.println("11. Exit");
        int option = scan.nextInt();
        switch(option){
            case 1 -> { System.out.println("Enter value: "); int val = scan.nextInt(); addAtHead(val); }
            case 2 -> { System.out.println("Enter value: "); int val = scan.nextInt(); addAtTail(val); }
            case 3 -> { 
                System.out.println("Enter value: "); 
                var val = scan.nextInt(); 
                System.out.println("Enter position: ");
                int pos = scan.nextInt(); 
                addAtPos(val, pos); 
            } 
            case 4 -> display();
            case 5 -> deleteFromHead();
            case 6 -> deleteFromTail();
            case 7 -> { 
                System.out.println("Enter position: ");
                int pos = scan.nextInt(); 
                deleteAtPos(pos); 
            } 
            case 8 -> System.out.printf("List contains %d elements",length);
            case 9 -> {System.out.println("Enter value: "); var value = scan.nextInt(); System.out.printf("Value %d found at position %d", value, getPosition(value));}
            case 10 -> reverseList();
            case 11 -> flag=false;
            default -> System.out.println("Wrong choice entered");
        }
        }
        }catch(Exception e){
            System.out.println("Error parsing user input");
        }
    }
    static void addAtHead(int val){
        var newNode = new DLLNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        length++;
    }
    static void addAtTail(int val){
        var newNode = new DLLNode(val);
        DLLNode ptr=head;
        if(head==null)
            head=newNode;
        else{
            while(ptr.next!=null){
                ptr=ptr.next;
            }
            ptr.next=newNode;
            newNode.prev=ptr;
        }
        length++;
    }
    static void addAtPos(int val, int pos) {
        var newNode = new DLLNode(val);
        if(pos<2){
            addAtHead(val);
        }else{
            DLLNode ptr=head;
            for(int i=1;i<pos;i++){
                ptr=ptr.next;
            }
            newNode.prev=ptr.prev;
            ptr.prev.next=newNode;
            newNode.next=ptr;
            ptr.prev=newNode;
        }
        length++;
    }
    static void display(){
        DLLNode ptr=head;
        System.out.print("NULL");
        while(ptr!=null){
            System.out.printf("<-| %d |->",ptr.val);
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }
    static void deleteFromHead(){
        if(head==null)
            return;
        head=head.next;
        length--;
    }
    static void deleteFromTail(){
        if(head==null || head.next==null){
            deleteFromHead();
            return;
        }
        DLLNode p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.prev.next=null;
        p.prev=null;
        length--;
    }
    static void deleteAtPos(int pos){
        if(pos==1){
            deleteFromHead();
            return;
        }
        DLLNode p=head;
        for(int i=1;i<pos;i++){
            p=p.next;
        }
        if(p.next!=null)
            p.next.prev=p.prev;
        
        p.prev.next=p.next;
        p.next=null;
        p.prev=null;
        length--;
    }
    static int getPosition(int val){
        int pos=0;
        for(DLLNode p=head;p!=null;p=p.next){
            if(p.val==val){
                return pos+1;
            }
            pos++;
        }
        return -1;
    }
    static void reverseList(){
        if(head==null)
            return;
        DLLNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            head=prev;
        }
    }

}

class DLLNode{
    int val;
    DLLNode next;
    DLLNode prev;
    public DLLNode(int val){
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}