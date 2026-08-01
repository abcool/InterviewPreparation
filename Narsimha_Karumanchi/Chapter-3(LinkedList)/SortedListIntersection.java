class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class SortedListIntersection {

    public static Node findIntersection(Node head1, Node head2) {
        Node ansHead = new Node(-1);
        Node ptr = ansHead;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                ptr.next = new Node(head1.data);
                ptr = ptr.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return ansHead.next;
    }

    // Creates a linked list from an array
    static Node createList(int[] arr) {
        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Prints a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    // Validate method
    static void validate() {
        // Test Case 1
        Node head1 = createList(new int[]{1, 2, 3, 4, 6});
        Node head2 = createList(new int[]{2, 4, 6, 8});

        System.out.println("Test Case 1");
        System.out.print("LinkedList1: ");
        printList(head1);
        System.out.print("LinkedList2: ");
        printList(head2);
        System.out.print("Intersection: ");
        printList(findIntersection(head1, head2));
        System.out.println();

        // Test Case 2
        head1 = createList(new int[]{10, 20, 40, 50});
        head2 = createList(new int[]{15, 40});

        System.out.println("Test Case 2");
        System.out.print("LinkedList1: ");
        printList(head1);
        System.out.print("LinkedList2: ");
        printList(head2);
        System.out.print("Intersection: ");
        printList(findIntersection(head1, head2));
    }

    public static void main(String[] args) {
        validate();
    }
}