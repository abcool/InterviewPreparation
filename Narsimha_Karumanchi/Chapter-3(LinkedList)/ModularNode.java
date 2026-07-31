import java.util.List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class ModularNode {

    public int modularNode(Node head, int k) {
        int pos = 1;
        int ans = -1;

        if (head == null || k <= 0)
            return -1;

        for (var ptr = head; ptr != null; ptr = ptr.next) {
            if (pos % k == 0)
                ans = ptr.data;
            pos++;
        }

        return ans;
    }

    public static void main(String[] args) {

        var solution = new ModularNode();

        var testCases = List.of(
                new TestCase(new int[]{19, 28, 37, 46, 55}, 2, 46),
                new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7}, 10, -1)
        );

        int testNo = 1;

        for (var test : testCases) {
            var head = ModularNodeTest.createList(test.values());

            System.out.println("Test Case " + testNo++);
            System.out.print("Input    : ");
            ModularNodeTest.display(head);
            System.out.println("k        : " + test.k());

            var actual = solution.modularNode(head, test.k());

            System.out.println("Expected : " + test.expected());
            System.out.println("Actual   : " + actual);
            System.out.println(actual == test.expected() ? "PASS" : "FAIL");
            System.out.println("-".repeat(40));
        }
    }
}

record TestCase(int[] values, int k, int expected) {}

class ModularNodeTest {

    public static Node createList(int[] values) {
        Node head = null;
        Node tail = null;

        for (var value : values) {
            var node = new Node(value);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    public static void display(Node head) {
        for (var ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.data);
            if (ptr.next != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }
}