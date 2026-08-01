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

public class AddNumbers {

    /**
     * Adds two numbers represented as linked lists.
     *
     * Example:
     * l1 = 2 -> 4 -> 3 (342)
     * l2 = 5 -> 6 -> 4 (465)
     * Result = 7 -> 0 -> 8 (807)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Pointers to traverse the input linked lists
        ListNode p = l1, q = l2;

        // Head of the answer list
        ListNode ans = null;

        // Pointer to the last node of the answer list
        ListNode ptr = null;

        // Stores carry generated after each addition
        int carry = 0;

        // Continue until both lists are exhausted and no carry remains
        while (p != null || q != null || carry != 0) {

            // Start with carry from previous iteration
            int sum = carry;

            // Add current digit from first list (if available)
            if (p != null) {
                sum += p.val;
                p = p.next;
            }

            // Add current digit from second list (if available)
            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            // Calculate carry and current digit
            carry = sum / 10;
            sum %= 10;

            // Create the first node of the answer list
            if (ans == null) {
                ans = new ListNode(sum);
                ptr = ans;
            }
            // Append remaining nodes
            else {
                ptr.next = new ListNode(sum);
                ptr = ptr.next;
            }
        }

        return ans;
    }

    /**
     * Creates a linked list from the given array.
     */
    private static ListNode createList(int... values) {

        ListNode head = null;
        ListNode ptr = null;

        for (int value : values) {

            ListNode node = new ListNode(value);

            if (head == null) {
                head = ptr = node;
            } else {
                ptr.next = node;
                ptr = ptr.next;
            }
        }

        return head;
    }

    /**
     * Converts a linked list into an integer array.
     */
    private static int[] toArray(ListNode head) {

        // Count the number of nodes
        int size = 0;
        for (ListNode p = head; p != null; p = p.next) {
            size++;
        }

        int[] result = new int[size];

        // Copy node values into the array
        int index = 0;
        for (ListNode p = head; p != null; p = p.next) {
            result[index++] = p.val;
        }

        return result;
    }

    /**
     * Executes a single test case and prints the result.
     */
    private static void validate(int[] l1, int[] l2, int[] expected) {

        AddNumbers solution = new AddNumbers();

        // Create input linked lists
        ListNode list1 = createList(l1);
        ListNode list2 = createList(l2);

        // Execute solution
        ListNode result = solution.addTwoNumbers(list1, list2);

        // Convert result to array for comparison
        int[] actual = toArray(result);

        System.out.println("Input 1 : " + Arrays.toString(l1));
        System.out.println("Input 2 : " + Arrays.toString(l2));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual  : " + Arrays.toString(actual));
        System.out.println(Arrays.equals(actual, expected) ? "PASS" : "FAIL");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {

        // Test Case 1
        validate(
                new int[]{2, 4, 3},
                new int[]{5, 6, 4},
                new int[]{7, 0, 8});

        // Test Case 2
        validate(
                new int[]{0},
                new int[]{0},
                new int[]{0});

        // Test Case 3
        validate(
                new int[]{9, 9, 9, 9, 9, 9, 9},
                new int[]{9, 9, 9, 9},
                new int[]{8, 9, 9, 9, 0, 0, 0, 1});
    }
}