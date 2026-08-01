import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }

    public void validate() {
        test(new int[]{1, 1, 2}, new int[]{1, 2});
        test(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 3});
    }

    private void test(int[] input, int[] expected) {
        ListNode head = createList(input);
        ListNode result = deleteDuplicates(head);

        int[] actual = toArray(result);

        if (Arrays.equals(actual, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Input    : " + Arrays.toString(input));
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Actual   : " + Arrays.toString(actual));
        }
    }

    private ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int[] arr = new int[length];
        temp = head;
        int i = 0;

        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        return arr;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().validate();
    }
}