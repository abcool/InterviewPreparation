class JosephusCircle {

    public int findTheWinner(int n, int k) {

        // Create circular linked list
        Node head = new Node(1);
        Node tail = head;

        for (int i = 2; i <= n; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = head;

        Node prev = tail;
        Node curr = head;

        while (n > 1) {

            int steps = (k - 1) % n;

            for (int i = 0; i < steps; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Remove current node
            prev.next = curr.next;
            curr = curr.next;

            n--;
        }

        return curr.val;
    }

    public static void main(String[] args) {
        validate();
    }

    private static void validate() {
        var solution = new JosephusCircle();

        test(solution, 5, 2, 3);
        test(solution, 6, 5, 1);
    }

    private static void test(JosephusCircle solution, int n, int k, int expected) {
        int actual = solution.findTheWinner(n, k);

        if (actual == expected) {
            System.out.printf("PASS: n=%d, k=%d -> %d%n", n, k, actual);
        } else {
            System.out.printf(
                "FAIL: n=%d, k=%d -> Expected: %d, Actual: %d%n",
                n, k, expected, actual
            );
        }
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}