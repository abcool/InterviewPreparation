import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class ReverseInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {

        // ptr -> starting node of the current group
        // prev -> tail of the previously reversed group
        ListNode ptr = head;
        ListNode prev = null;

        while (ptr != null) {

            // Find the kth node from the current group.
            // If it doesn't exist, fewer than k nodes remain.
            ListNode kthNode = getKthNode(ptr, k);

            if (kthNode == null) {
                // Attach the remaining nodes without reversing them.
                if (prev != null)
                    prev.next = ptr;
                break;
            }

            // Save the start of the next group.
            ListNode nextNode = kthNode.next;

            // Detach the current group.
            kthNode.next = null;

            // Reverse the current group.
            ListNode reversedHead = reverse(ptr);

            // Update the head if this is the first group.
            if (ptr == head)
                head = reversedHead;
            else
                // Connect the previous reversed group to this one.
                prev.next = reversedHead;

            // After reversal, ptr becomes the tail of the current group.
            prev = ptr;

            // Process the next group.
            ptr = nextNode;
        }

        return head;
    }

    // Returns the kth node (1-indexed) from head.
    // Returns null if fewer than k nodes remain.
    private ListNode getKthNode(ListNode head, int k) {

        ListNode temp = head;

        for (int i = 1; i < k; i++) {
            if (temp == null)
                break;
            temp = temp.next;
        }

        return temp;
    }

    // Standard iterative linked list reversal.
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        ReverseInKGroups solution = new ReverseInKGroups();

        test(
                solution,
                new int[]{1, 2, 3, 4, 5},
                2,
                new int[]{2, 1, 4, 3, 5}
        );

        test(
                solution,
                new int[]{1, 2, 3, 4, 5},
                3,
                new int[]{3, 2, 1, 4, 5}
        );

        test(
                solution,
                new int[]{1},
                2,
                new int[]{1}
        );
    }

    private static void test(
            ReverseInKGroups solution,
            int[] input,
            int k,
            int[] expected) {

        ListNode head = createList(input);

        ListNode result = solution.reverseKGroup(head, k);

        int[] actual = toArray(result);

        System.out.println("------------------------------------------------");
        System.out.println("Input    : " + Arrays.toString(input));
        System.out.println("k        : " + k);
        System.out.println("Expected : " + Arrays.toString(expected));
        System.out.println("Actual   : " + Arrays.toString(actual));
        System.out.println(Arrays.equals(expected, actual)
                ? "Result   : PASS"
                : "Result   : FAIL");
    }

    private static ListNode createList(int[] arr) {

        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    private static int[] toArray(ListNode head) {

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];

        temp = head;
        int index = 0;

        while (temp != null) {
            arr[index++] = temp.val;
            temp = temp.next;
        }

        return arr;
    }
}