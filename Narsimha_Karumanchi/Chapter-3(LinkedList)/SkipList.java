import java.util.*;

class SkipList {
    private static Node head;      // The starting point (top-leftmost node) of the entire Skip List
    private static Random random;  // Used to flip a coin and determine node heights
    private static long size;      // Total number of unique elements in the base list
    private static double p;       // Probability factor (usually 0.5 for a 50% chance to climb up)

    public static void main(String[] args) {
        // Initialize the head with a dummy tower at level 0
        head = new Node(Integer.MIN_VALUE, 0, 0, null, null);
        random = new Random();
        size = 0;
        p = 0.5;
        boolean flag = true;
        
        // Use ONE Scanner instance to prevent breaking System.in
        var scan = new Scanner(System.in);
        while (flag) {
            System.out.println("\nEnter a choice:");
            System.out.println("1. Add to list");
            System.out.println("2. Remove from list");
            System.out.println("3. Get location of element");
            System.out.println("4. Print list");
            System.out.println("5. Exit");
            var choice = scan.nextInt();
            switch (choice) {
                case 1 -> add(scan);
                case 2 -> remove(scan);
                case 3 -> find(scan);
                case 4 -> display();
                case 5 -> flag = false;
            }
        }
        scan.close();
    }

    /**
     * Simulates flipping a coin. As long as it lands heads (probability p),
     * we increase the level (height) of the new node tower.
     */
    private static long getLevel(){
    long level = 0; // 1. Start at the base level (Layer 0)
    
    // 2. Flip a coin. As long as it's "heads" (less than p) 
    // AND we haven't exceeded the current size of the list, keep climbing.
    // The condition level <= size is a safety constraint. It prevents the random generator from accidentally creating an astronomically tall tower 
    // (e.g., a level 50 tower when there are only 3 elements in the list),
    while(level <= size && random.nextDouble() < p){
        level++; // 3. Grow the tower by one level
    }
    return level; // 4. Return the final height for this node
}

    private static void add(Scanner scan) {
        System.out.println("Enter key and value:");
        int key = scan.nextInt();
        int value = scan.nextInt();
        long level = getLevel();

        // If the new tower is taller than our current maximum height,
        // we grow the 'head' dummy tower upwards to match it.
        while (level > head.level) {
            head = new Node(Integer.MIN_VALUE, 0, head.level + 1, null, head);
        }

        Node curr = head;
        Node lastToplevelNode = null; // Keeps track of the node inserted directly above to link 'down' pointers

        while (curr != null) {
            // Move right if the next node's key is smaller than the target key
            if (curr.next != null && curr.next.key < key) {
                curr = curr.next;
            } 
            // If the key already exists, update its value across all levels
            else if (curr.next != null && curr.next.key == key) {
                curr.next.value = value;
                curr = curr.down; // Drop down to update the value in lower levels too
            } 
            // If the next node is null or its key is larger, we must insert here (if our level allows it)
            else {
                if (curr.level <= level) {
                    // Create a new node and splice it into the horizontal linked list
                    Node n = new Node(key, value, curr.level, curr.next, null);
                    curr.next = n;

                    // Vertically link the tower: if we created a node on a level above, link it to this one
                    if (lastToplevelNode != null) {
                        lastToplevelNode.down = n;
                    }
                    lastToplevelNode = n; // Remember this node for the level below
                }
                curr = curr.down; // Move down to the next level to continue insertion
            }
        }
        size++;
    }

    private static void remove(Scanner scan) {
        System.out.println("Enter key to remove:");
        int key = scan.nextInt();
        Node curr = head;
        boolean removed = false;

        while (curr != null) {
            // Move right if the next node's key is smaller than the key we want to delete
            if (curr.next != null && curr.next.key < key) {
                curr = curr.next;
            } 
            // If we found the key on this level, bypass it (un-link it)
            else if (curr.next != null && curr.next.key == key) {
                curr.next = curr.next.next; 
                removed = true;
                curr = curr.down; // Drop down to remove it from lower levels as well
            } 
            // If next is null or greater, drop down a level
            else {
                curr = curr.down;
            }
        }
        if (removed) size--;
    }

    private static void find(Scanner scan) {
        System.out.println("Enter key to find:");
        int key = scan.nextInt();
        Node curr = head;

        while (curr != null) {
            // Move right if the next key is smaller
            if (curr.next != null && curr.next.key < key) {
                curr = curr.next;
            } 
            // Found it! Print out its value
            else if (curr.next != null && curr.next.key == key) {
                System.out.printf("%d found with value %d\n", key, curr.next.value);
                return;
            } 
            // Next key is too big or null, drop down to a more precise layer
            else {
                curr = curr.down;
            }
        }
        System.out.println("Key not found.");
    }

    /**
     * Bonus: Implementation of display() to help you visualize your levels!
     */
    private static void display() {
        System.out.println("\n--- Skip List Visual ---");
        Node levelHead = head;
        while (levelHead != null) {
            System.out.print("Level " + levelHead.level + ": [Head]-> ");
            Node curr = levelHead.next;
            while (curr != null) {
                System.out.print("(" + curr.key + ":" + curr.value + ") -> ");
                curr = curr.next;
            }
            System.out.println("null");
            levelHead = levelHead.down; // Go down to the next level row
        }
        System.out.println("------------------------");
    }
}

class Node {
    public int key;
    public int value;
    public long level; // Which level row this specific node lives on
    public Node next;  // Pointer to the right (next node in the same layer)
    public Node down;  // Pointer to the bottom (same key, one layer below)

    public Node(int key, int value, long level, Node next, Node down) {
        this.key = key;
        this.value = value;
        this.level = level;
        this.next = next;
        this.down = down;
    }
}