import java.util.HashSet;
import java.util.Set;

/* Structure of linked list Node */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class RemoveDuplicatesUnsorted {

    public Node removeDuplicates(Node head) {
        if (head == null)
            return null;

        Set<Integer> seen = new HashSet<>();
        seen.add(head.data);

        Node ptr = head;

        while (ptr.next != null) {
            if (seen.add(ptr.next.data)) {
                ptr = ptr.next;
            } else {
                ptr.next = ptr.next.next;
            }
        }
        return head;
    }

    // Creates a linked list from an array
    private static Node createList(int[] arr) {
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

    // Prints the linked list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Validates all test cases
    public static void validate() {
        RemoveDuplicatesUnsorted solution = new RemoveDuplicatesUnsorted();

        int[][] tests = {
                {5, 2, 2, 4},
                {2, 2, 2, 2, 2},
                {} // Empty list
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test Case " + (i + 1));

            Node head = createList(tests[i]);

            System.out.print("Input : ");
            printList(head);

            head = solution.removeDuplicates(head);

            System.out.print("Output: ");
            printList(head);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        validate();
    }
}