/*
Algorithm:

1. Interleave copied nodes with original nodes.
   A -> B -> C
   becomes
   A -> A' -> B -> B' -> C -> C'

2. Copy random pointers.
   copy.random = original.random.next

3. Detach the interleaved list into:
   Original: A -> B -> C
   Copy    : A' -> B' -> C'

Time Complexity : O(n)
Space Complexity: O(1) (excluding the cloned list)
*/

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

record TestCase(Integer[][] input) {}

public class CloneListWithRandomPointer {

    public Node copyRandomList(Node head) {

        // Empty list, nothing to clone
        if (head == null)
            return null;

        // p traverses the original list
        // q is used to create and traverse copied nodes
        Node p = head, q;

        // ==========================================================
        // Step 1: Insert a copy of every node immediately after it
        //
        // Before:
        // A -> B -> C
        //
        // After:
        // A -> A' -> B -> B' -> C -> C'
        // ==========================================================
        while (p != null) {

            // Create a copy of the current original node
            q = new Node(p.val);

            // Copy node points to original node's next
            q.next = p.next;

            // Insert the copy immediately after the original node
            p.next = q;

            // Move to the next original node
            p = q.next;
        }

        // ==========================================================
        // Step 2: Assign random pointers to copied nodes
        //
        // Since every copied node follows its original:
        //
        // Original:
        // A.random -> C
        //
        // Interleaved:
        // A -> A' -> B -> B' -> C -> C'
        //
        // Therefore:
        // A'.random = C'
        //            = A.random.next
        // ==========================================================
        p = head;

        while (p != null) {

            // If original node has a random pointer
            if (p.random != null)

                // Point copied node's random to the copied random node
                p.next.random = p.random.next;

            // Skip the copied node and move to the next original node
            p = p.next.next;
        }

        // ==========================================================
        // Step 3: Separate the original and copied lists
        //
        // Current:
        // A -> A' -> B -> B' -> C -> C'
        //
        // Original:
        // A -> B -> C
        //
        // Copied:
        // A' -> B' -> C'
        // ==========================================================

        // Start from the original list
        p = head;

        // Head of the cloned list
        Node head2 = head.next;

        // Start traversing the cloned list
        q = head2;

        while (p != null) {

            // Restore original node's next pointer
            // Example:
            // A -> A' -> B
            // becomes
            // A -> B
            p.next = q.next;

            // Move to the next original node
            p = p.next;

            // If another original node exists
            if (p != null) {

                // Connect current copied node to the next copied node
                // Example:
                // A' -> B'
                q.next = p.next;

                // Move to the next copied node
                q = q.next;
            }
        }

        // Return the head of the deep-copied list
        return head2;
    }

    public static void main(String[] args) {

        TestCase[] tests = {
                new TestCase(new Integer[][]{
                        {7, null},
                        {13, 0},
                        {11, 4},
                        {10, 2},
                        {1, 0}
                }),
                new TestCase(new Integer[][]{
                        {1, 1},
                        {2, 1}
                }),
                new TestCase(new Integer[][]{
                        {3, null},
                        {3, 0},
                        {3, null}
                })
        };

        for (TestCase test : tests) {
            validate(test);
        }
    }

    static void validate(TestCase test) {

        Node head = buildList(test.input());

        CloneListWithRandomPointer solution = new CloneListWithRandomPointer();
        Node copiedHead = solution.copyRandomList(head);

        Integer[][] actual = serialize(copiedHead);

        System.out.println("----------------------------------------");
        System.out.println("Input    : " + Arrays.deepToString(test.input()));
        System.out.println("Expected : " + Arrays.deepToString(test.input()));
        System.out.println("Actual   : " + Arrays.deepToString(actual));
        System.out.println(Arrays.deepEquals(test.input(), actual)
                ? "PASSED"
                : "FAILED");
    }

    static Node buildList(Integer[][] arr) {

        if (arr.length == 0)
            return null;

        Node[] nodes = new Node[arr.length];

        // Create nodes
        for (int i = 0; i < arr.length; i++)
            nodes[i] = new Node(arr[i][0]);

        // Set next pointers
        for (int i = 0; i < arr.length - 1; i++)
            nodes[i].next = nodes[i + 1];

        // Set random pointers
        for (int i = 0; i < arr.length; i++) {
            Integer randomIndex = arr[i][1];
            if (randomIndex != null)
                nodes[i].random = nodes[randomIndex];
        }

        return nodes[0];
    }

    static Integer[][] serialize(Node head) {

        List<Node> nodes = new ArrayList<>();

        Node current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        Integer[][] result = new Integer[nodes.size()][2];

        for (int i = 0; i < nodes.size(); i++) {

            result[i][0] = nodes.get(i).val;

            if (nodes.get(i).random == null)
                result[i][1] = null;
            else
                result[i][1] = nodes.indexOf(nodes.get(i).random);
        }

        return result;
    }
}