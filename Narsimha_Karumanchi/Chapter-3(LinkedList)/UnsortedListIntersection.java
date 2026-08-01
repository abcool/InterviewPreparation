import java.util.HashSet;
import java.util.Set;

/* Structure of list node */
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class UnsortedListIntersection {

    public Node findIntersection(Node head1, Node head2) {
        // Stores all unique elements of head2
        Set<Integer> seen = new HashSet<>();

        // Dummy node to simplify insertion into answer list
        Node ansHead = new Node(-1);
        var tail = ansHead;

        // Add all elements of second list into HashSet
        for (Node ptr = head2; ptr != null; ptr = ptr.next) {
            seen.add(ptr.data);
        }

        // Traverse first list in original order
        for (Node ptr = head1; ptr != null; ptr = ptr.next) {

            // If current element exists in second list,
            // add it to answer and remove it to avoid duplicates.
            if (seen.contains(ptr.data)) {
                tail.next = new Node(ptr.data);
                tail = tail.next;
                seen.remove(ptr.data);
            }
        }

        return ansHead.next;
    }

    // Prints a linked list
    private void printList(Node head) {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.data);
            if (ptr.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    // Runs the given test cases
    public void validate() {

        // ---------------- Test Case 1 ----------------
        Node head1 = new Node(9);
        head1.next = new Node(6);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(3);
        head1.next.next.next.next.next = new Node(8);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(6);

        System.out.print("Test Case 1 Output: ");
        printList(findIntersection(head1, head2));
        // Expected: 6->2->8

        // ---------------- Test Case 2 ----------------
        head1 = new Node(5);
        head1.next = new Node(3);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(13);
        head1.next.next.next.next = new Node(14);

        head2 = new Node(3);
        head2.next = new Node(13);

        System.out.print("Test Case 2 Output: ");
        printList(findIntersection(head1, head2));
        // Expected: 3->13
    }

    public static void main(String[] args) {
        new UnsortedListIntersection().validate();
    }
}