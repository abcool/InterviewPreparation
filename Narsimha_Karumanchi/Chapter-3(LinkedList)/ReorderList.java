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

public class ReorderList {

    /**
     * Reorders the linked list in the following pattern:
     *
     * L0 → L1 → L2 → ... → Ln
     *
     * becomes
     *
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...
     *
     * Algorithm:
     * 1. Find the middle of the linked list.
     * 2. Reverse the second half.
     * 3. Merge the first and reversed second half alternately.
     *
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {

        // Empty list or single node is already reordered.
        if (head == null || head.next == null)
            return;

        // Find the middle node.
        // Example:
        // 1 -> 2 -> 3 -> 4 -> 5
        //           ^
        var middle = returnMiddle(head);

        // Reverse the second half.
        // Before : 4 -> 5
        // After  : 5 -> 4
        var second = reverseList(middle.next);

        // Split the list into two independent halves.
        middle.next = null;

        // Pointer to traverse first half.
        var p = head;

        // Merge the two halves alternately.
        //
        // Example:
        //
        // First : 1 -> 2 -> 3
        // Second: 5 -> 4
        //
        // Iteration 1:
        // 1 -> 5 -> 2 -> 3
        //
        // Iteration 2:
        // 1 -> 5 -> 2 -> 4 -> 3
        while (second != null) {

            // Save next node of first half.
            var temp = p.next;

            // Insert current node from second half.
            p.next = second;

            // Move first-half pointer forward.
            p = temp;

            // Save next node of reversed second half.
            temp = second.next;

            // Connect inserted node to remaining first half.
            second.next = p;

            // Move second-half pointer forward.
            second = temp;
        }
    }

    /**
     * Returns the last node of the first half.
     *
     * For even length:
     * 1 2 3 4
     *     ^
     * returns node 2
     *
     * For odd length:
     * 1 2 3 4 5
     *       ^
     * returns node 3
     */
    private ListNode returnMiddle(ListNode head) {
        ListNode p = head, q = head;

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        return p;
    }

    /**
     * Reverses a linked list.
     *
     * Example:
     * 4 -> 5 -> null
     *
     * becomes
     *
     * 5 -> 4 -> null
     */
    private ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // ---------------------------------------------------------------------
    // Validation
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        validate();
    }

    private static void validate() {
        ReorderList solution = new ReorderList();

        // Test Case 1
        ListNode head1 = createList(1, 2, 3, 4);
        solution.reorderList(head1);

        int[] expected1 = {1, 4, 2, 3};
        int[] actual1 = toArray(head1);

        System.out.println("Input    : [1, 2, 3, 4]");
        System.out.println("Expected : " + Arrays.toString(expected1));
        System.out.println("Actual   : " + Arrays.toString(actual1));
        System.out.println(Arrays.equals(expected1, actual1) ? "PASS\n" : "FAIL\n");

        // Test Case 2
        ListNode head2 = createList(1, 2, 3, 4, 5);
        solution.reorderList(head2);

        int[] expected2 = {1, 5, 2, 4, 3};
        int[] actual2 = toArray(head2);

        System.out.println("Input    : [1, 2, 3, 4, 5]");
        System.out.println("Expected : " + Arrays.toString(expected2));
        System.out.println("Actual   : " + Arrays.toString(actual2));
        System.out.println(Arrays.equals(expected2, actual2) ? "PASS" : "FAIL");
    }

    private static ListNode createList(int... values) {
        if (values.length == 0)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private static int[] toArray(ListNode head) {
        int size = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            size++;

        int[] result = new int[size];

        int i = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            result[i++] = curr.val;

        return result;
    }
}