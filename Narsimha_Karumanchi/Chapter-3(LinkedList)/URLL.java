import java.util.*;
class URLL{

    static URNode head;
    static int arrayCapacity;
    static int listSize;

    public static void main(String[] args) {
        try(var scan = new Scanner(System.in)){
        boolean flag=true;
        System.out.println("Enter array capacity");
        var capacity = scan.nextInt();
        if(capacity<2) throw new IllegalArgumentException("Need a minimum capacity of 2 for node split operation");
        arrayCapacity = capacity;
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
            case 1 -> { System.out.println("Enter value: "); int val = scan.nextInt(); insertAtBegin(val); }
            case 2 -> { System.out.println("Enter value: "); int val = scan.nextInt(); insertAtEnd(val); }
            case 3 -> { 
                System.out.println("Enter value: "); 
                var val = scan.nextInt(); 
                System.out.println("Enter position: ");
                int pos = scan.nextInt(); 
                insertAtPos(val, pos); 
            } 
            case 4 -> printList();
            case 5 -> deleteFromBegin();
            case 6 -> deleteFromEnd();
            case 7 -> { 
                System.out.println("Enter position: ");
                int pos = scan.nextInt(); 
                deleteAtPos(pos); 
            } 
            case 8 -> System.out.printf("List contains %d elements",listSize);
            case 9 -> {System.out.println("Enter value: "); var value = scan.nextInt(); System.out.printf("Value %d found at position %d", value, getPosition(value));}
            case 10 -> flag=false;
            default -> System.out.println("Wrong choice entered");
        }
        }
        }catch(Exception e){
            System.out.println("Error parsing user input");
        }
    }

    /**
     * Algorithm
     * IF head == NULL
            create block
            insert value
            head = block
            listSize++
            return

        IF head has free space

            shift all elements one step right

            data[0]=value
            count++

        ELSE

            create new block
            data[0]=value
            next=head
            head=new block
            listSize++
     */

    static void insertAtBegin(int val) {
        // Case 1: The list is entirely empty
        if (head == null) {
            var newNode = new URNode(arrayCapacity);
            newNode.values[0] = val;
            newNode.filled++;
            head = newNode;
            listSize++;
            return;
        }

        // Case 2: The head node is FULL
        // Instead of splitting and shifting half the elements, we simply link a 
        // brand new node at the absolute front. This runs in O(1) time!
        if (head.filled == arrayCapacity) {
            var newNode = new URNode(arrayCapacity);
            newNode.values[0] = val;
            newNode.filled++;
            
            newNode.next = head; // Point new node to the old head
            head = newNode;      // Update head pointer to the new node
            listSize++;          // A new node was added to the list
            return;              // We are done!
        }

        // Case 3: The head node has space
        // Shift elements to the right to make room at index 0
        for (int i = head.filled; i > 0; i--) {
            head.values[i] = head.values[i - 1];
        }
        head.values[0] = val;
        head.filled++;
    }

    /**
     * Algorithm
     * IF head==NULL

            create first block
            insert value
            return

        Go to last block

        IF last block not full

            append value

        ELSE

            create new block
            insert value
            attach after last
            listSize++
     */

    static void insertAtEnd(int val){
        if(head==null){
            head= new URNode(arrayCapacity);
            head.values[0]=val;
            head.filled++;
            listSize++;
            return;
        }
        URNode ptr = head;
        while(ptr.next!=null){
            ptr= ptr.next;
        }
        if(ptr.filled==arrayCapacity){
            var newNode = new URNode(arrayCapacity);
            newNode.values[0]=val;
            newNode.filled++;
            ptr.next=newNode;
            listSize++;
        }else{
            ptr.values[ptr.filled++]=val;
        }
        
    }

    static void insertAtPos(int val, int pos) {
        // Boundary check for 1-based indexing (cannot be less than 1)
        if (pos < 1) {
            throw new IllegalArgumentException("Position must be 1 or greater");
        }

        // Case 1: The list is entirely empty
        if (head == null) {
            if (pos != 1) { // First element must be inserted at position 1
                throw new IllegalArgumentException("Position out of bounds for empty list");
            }
            head = new URNode(arrayCapacity);
            head.values[0] = val; // Internal array is still 0-indexed dynamically
            head.filled++; 
            listSize++; // First node created
            return;
        }

        URNode ptr = head;
        
        /* * 'traversed' tracks the cumulative number of elements we have skipped 
        * in all the nodes we've already passed through. 
        * It acts as a running offset to map global positions to local node arrays.
        */
        int traversed = 0;

        // Step 1: Traverse to find the correct node
        while (ptr != null) {
            /* * For 1-based indexing: (traversed + ptr.filled) is the global position of the 
            * very last element in the current node. If the target 'pos' is less than 
            * or equal to this, the position falls inside this specific node.
            */
            if (traversed + ptr.filled >= pos) {
                break;
            }
            
            // Add the current node's elements to our running total before moving to the next node
            traversed += ptr.filled;
            
            // Special case: If we are appending right after the last element of the entire list
            if (ptr.next == null && traversed + 1 == pos) {
                break;
            }
            
            ptr = ptr.next;
        }

        // If we blew past the end of the list, the position was too high
        if (ptr == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        /* * By subtracting 'traversed' from 'pos', we convert the global 1-based position 
        * into a local 1-based index. We then subtract 1 to align it with Java's 
        * native 0-indexed array system: index = (pos - traversed) - 1
        */
        int index = pos - traversed - 1;

        // Case 2: The target node has space
        if (ptr.filled < arrayCapacity) {
            shiftRightAndInsert(ptr, index, val);
        } 
        // Case 3: The target node is FULL -> Split it
        else {
            URNode newNode = new URNode(arrayCapacity);
            int mid = arrayCapacity / 2;

            // Move the second half of elements to the new node
            for (int i = mid; i < arrayCapacity; i++) {
                newNode.values[i - mid] = ptr.values[i];
                newNode.filled++;
            }
            ptr.filled = mid; // Update ptr node's count

            // Link the new node into the list
            newNode.next = ptr.next;
            ptr.next = newNode;
            
            listSize++; // A new node was added to the list!

            // Insert the target value into the correct node split
            if (index <= mid) {
                shiftRightAndInsert(ptr, index, val);
            } else {
                shiftRightAndInsert(newNode, index - mid, val);
            }
        }
    }

    // Helper method to shift elements right and insert the value locally
    private static void shiftRightAndInsert(URNode node, int localIdx, int val) {
        for (int i = node.filled; i > localIdx; i--) {
            node.values[i] = node.values[i - 1];
        }
        node.values[localIdx] = val;
        node.filled++;
    }

    static void printList(){
        if(listSize<1){
            System.out.println("NULL");
            return;
        }
        URNode ptr=head;
        while(ptr!=null){
            for(int i=0;i<ptr.filled;i++){
                System.out.printf("| %d |->",ptr.values[i]);
            }
            ptr=ptr.next;
        }

    }

    static void deleteFromBegin(){
        if(head==null){
            return;
        }
        if(head.filled>1){
            for(int i=0;i<head.filled;i++){
                head.values[i]=head.values[i+1];
            }
            head.filled--;
        }else{
            head=head.next;
            listSize--;
        }

    }

    static void deleteFromEnd(){
        if(head==null) return;
        URNode ptr=head;
        if(head.next==null){
            if(head.filled>1){
                head.values[head.filled-1]=0;
                head.filled--;
                return;
            }
            head=null;
            listSize--;
            return;
        }
        while(ptr.next.next!=null){
            ptr=ptr.next;
        }

        if(ptr.next.filled>1){
            ptr.next.values[ptr.next.filled-1]=0;
            ptr.next.filled--;
        }else{
            ptr.next=null;
            listSize--;
        }
    }

    static void deleteAtPos(int pos){

    }

    static int getPosition(int val){
        return 0;
    }

}

class URNode{
    int filled;
    int[] values;
    URNode next;

    public URNode(int arrayCapacity){
        this.values = new int[arrayCapacity];
    }
}