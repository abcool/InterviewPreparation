import java.util.Arrays;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class PartitionList {

    /**
     * Partitions the linked list around x while preserving
     * the relative order of nodes in each partition.
     */
    public ListNode partition(ListNode head, int x) {

        // Dummy heads for the two partitions.
        var lesser_head = new ListNode(0);
        var greater_head = new ListNode(0);

        // Tail pointers for building the partitions.
        var lesser = lesser_head;
        var greater = greater_head;

        // Traverse the original list once.
        while (head != null) {

            // Append node to the appropriate partition.
            if (head.val < x) {
                lesser.next = head;
                lesser = lesser.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // Prevent cycle by terminating the greater list.
        greater.next = null;

        // Connect the two partitions.
        lesser.next = greater_head.next;

        // Return the head of the partitioned list.
        return lesser_head.next;
    }

    /**
     * Runs all sample test cases.
     */
    public static void validate() {
        var solution = new PartitionList();

        // Test Case 1
        runTest(
                solution,
                new int[]{1, 4, 3, 2, 5, 2},
                3,
                new int[]{1, 2, 2, 4, 3, 5}
        );

        // Test Case 2
        runTest(
                solution,
                new int[]{2, 1},
                2,
                new int[]{1, 2}
        );
    }

    /**
     * Builds the input list, executes the algorithm,
     * and compares the result with the expected output.
     */
    private static void runTest(
            PartitionList solution,
            int[] input,
            int x,
            int[] expected) {

        var head = buildList(input);

        var result = solution.partition(head, x);

        var actual = toArray(result);

        if (Arrays.equals(actual, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + Arrays.toString(input));
            System.out.println("x        : " + x);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(actual));
        }
    }

    /**
     * Creates a linked list from an integer array.
     */
    private static ListNode buildList(int[] values) {

        // Dummy node simplifies insertion logic.
        var dummy = new ListNode(0);
        var current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * Converts a linked list back into an integer array.
     */
    private static int[] toArray(ListNode head) {

        // Find the length of the list.
        int size = 0;
        for (var current = head; current != null; current = current.next) {
            size++;
        }

        var result = new int[size];

        // Copy node values into the array.
        int index = 0;
        for (var current = head; current != null; current = current.next) {
            result[index++] = current.val;
        }

        return result;
    }

    public static void main(String[] args) {
        validate();
    }
}