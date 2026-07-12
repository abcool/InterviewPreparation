import java.util.*;
class CLL{
    static CLLNode head;
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
        System.out.println("10. Exit");
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
            case 10 -> flag=false;
            default -> System.out.println("Wrong choice entered");
        }
        }
        }catch(Exception e){
            System.out.println("Error parsing user input");
        }
    }
    static void addAtHead(int val){
        CLLNode newNode = new CLLNode(val);
        newNode.next=newNode;
        if(head==null){
            head=newNode;
            length++;
            return;
        }
        CLLNode ptr=head;
        while(ptr.next!=head)
            ptr=ptr.next;
        newNode.next=head;
        ptr.next=newNode;
        head=newNode;
        length++;
    }
    static void addAtTail(int val){
       CLLNode newNode = new CLLNode(val);
       newNode.next=newNode;
       if(head==null){
        head=newNode;
        length++;
        return;
       }
       CLLNode ptr=head;
       while(ptr.next!=head){
        ptr=ptr.next;
       }
       ptr.next=newNode;
       newNode.next=head;
        length++;
    }
    static void addAtPos(int val, int pos) {
        if(pos<2){
            addAtHead(val);
            return;
        }
        if(pos>length){
            addAtTail(val);
            return;
        }
        CLLNode ptr = head;
        CLLNode newNode = new CLLNode(val);
        for(int i=1;i<pos-1;i++){
            ptr=ptr.next;
        }
        newNode.next=ptr.next;
        ptr.next=newNode;
        length++;
    }
    static void display(){
        if(length==0){
            System.out.println("NULL");return;
        }
        CLLNode ptr=head;
        
        while(ptr.next!=head){
            System.out.printf("| %d |->",ptr.val);
            ptr=ptr.next;
        }
        if(ptr.next==head)
            System.out.printf("| %d |->",ptr.val);
    }
    static void deleteFromHead(){
        if(head==null) return;
        if(head.next==head){
            head=null; 
            length--; 
            return;
        }
        CLLNode ptr=head;
        while(ptr.next!=head){
            ptr=ptr.next;
        }
        head=head.next;
        ptr.next=head;
        length--;
    }
    static void deleteFromTail(){
       if(head==null || head.next==head){
        deleteFromHead();
        return;
       }
       CLLNode ptr=head;
       while(ptr.next.next!=head){
        ptr=ptr.next;
       }
       ptr.next=head;
        length--;
    }
    static void deleteAtPos(int pos){
        if(pos<2){
            deleteFromHead();
            return;
        }
        if(pos==length){
            deleteFromTail();
            return;
        }
        CLLNode ptr=head;
        for(int i=1;i<pos-1;i++){
            ptr=ptr.next;
        }
        ptr.next=ptr.next.next;
        length--;
    }
    static int getPosition(int val){
        if(val==head.val) return 1;
        int pos=1;
        boolean found=false;
        CLLNode ptr=head;
        while(ptr.next!=head){
            if(ptr.val==val){
                found=true;
                break;
            }
            pos++;
        }
        return found==true?pos:-1;
    }
}
class CLLNode{
    int val;
    CLLNode next;

    public CLLNode(int val) {
        this.val=val;
    }
    
}
