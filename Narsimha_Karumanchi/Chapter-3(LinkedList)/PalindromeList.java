import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {

    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        var p = head;
        var slowPtr = returnMiddle(head);
        var q = reverseList(slowPtr);

        while (q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        var current = head;

        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private ListNode returnMiddle(ListNode head) {
        var fastPtr = head;
        var slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Odd-length list: skip the middle node
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }

    // ---------------- Validation ----------------

    private record TestCase(int[] input, boolean expected) {}

    public static void validateLogic() {
        var solution = new PalindromeList();

        List.of(
                new TestCase(new int[]{1, 2, 2, 1}, true),
                new TestCase(new int[]{1, 2}, false),
                new TestCase(new int[]{1, 2, 1, 2}, false),
                new TestCase(new int[]{}, true),
                new TestCase(new int[]{1}, true)
        ).forEach(test -> runTest(solution, test));
    }

    private static void runTest(PalindromeList solution, TestCase test) {
        var head = createList(test.input());
        var actual = solution.isPalindrome(head);

        System.out.printf(
                "Input: %-15s Expected: %-5s Actual: %-5s %s%n",
                Arrays.toString(test.input()),
                test.expected(),
                actual,
                actual == test.expected() ? "PASS ✅" : "FAIL ❌"
        );
    }

    private static ListNode createList(int[] values) {
        var dummy = new ListNode(0);
        var current = dummy;

        for (var value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        validateLogic();
    }
}