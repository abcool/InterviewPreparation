import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // Calculate length of the list and keep track of the tail node.
        int len = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            len++;
        }

        // Avoid unnecessary full rotations.
        k %= len;

        // No rotation required.
        if (k == 0)
            return head;

        // Find the last node of the first part.
        ListNode lastNode = head;
        for (int i = 1; i < len - k; i++) {
            lastNode = lastNode.next;
        }

        // New head is the first node of the second part.
        ListNode newHead = lastNode.next;

        // Break the list into two parts.
        lastNode.next = null;

        // Connect the original tail to the original head.
        ptr.next = head;

        return newHead;
    }

    /**
     * Validates the rotateRight() method using the provided test cases.
     */
    public static void validate() {
        var solution = new RotateList();

        // Test Case 1
        var head1 = createList(1, 2, 3, 4, 5);
        var result1 = solution.rotateRight(head1, 2);
        assertListEquals(new int[]{4, 5, 1, 2, 3}, result1, "Test Case 1");

        // Test Case 2
        var head2 = createList(0, 1, 2);
        var result2 = solution.rotateRight(head2, 4);
        assertListEquals(new int[]{2, 0, 1}, result2, "Test Case 2");
    }

    /**
     * Creates a linked list from the supplied values.
     */
    private static ListNode createList(int... values) {
        if (values.length == 0)
            return null;

        var head = new ListNode(values[0]);
        var current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Converts a linked list into an integer array.
     */
    private static int[] toArray(ListNode head) {
        int size = 0;
        for (var current = head; current != null; current = current.next) {
            size++;
        }

        var result = new int[size];
        int index = 0;

        for (var current = head; current != null; current = current.next) {
            result[index++] = current.val;
        }

        return result;
    }

    /**
     * Compares the actual linked list with the expected output.
     */
    private static void assertListEquals(int[] expected, ListNode actual, String testName) {
        var actualArray = toArray(actual);

        if (Arrays.equals(expected, actualArray)) {
            System.out.println("✓ " + testName + " PASSED");
        } else {
            System.out.println("✗ " + testName + " FAILED");
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(actualArray));
        }
    }

    public static void main(String[] args) {
        validate();
    }
}