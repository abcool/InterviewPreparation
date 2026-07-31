/**
 * Given the head of a singly linked list and an integer k, find the (n/k)th node in the linked list, 
 * where n is the total number of nodes.If the value of n/k is not an integer, then consider its ceiling value.
 */
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class FractionalNode {

    public static int fractionalNode(Node head, int k) {
        // Return -1 if the list is empty or k is invalid
        if (head == null || k <= 0)
            return -1;

        // Will eventually point to the required fractional node
        Node ans = null;

        // Counts the total number of nodes visited so far
        int n = 0;

        // Traverse the linked list from beginning to end
        for (Node ptr = head; ptr != null; ptr = ptr.next) {

            // Increment the node count
            n++;

            // Every kth node encountered...
            if (n % k == 0) {

                // ...initialize ans to the head on the first multiple of k
                if (ans == null) {
                    ans = head;
                } else {
                    // ...otherwise move ans one step forward
                    // This keeps ans synchronized with floor(n / k)
                    ans = ans.next;
                }
            }
        }

        // If the total number of nodes is not exactly divisible by k,
        // move ans one extra step to obtain the ceil(n / k)th node.
        if (n % k != 0)
            ans = ans.next;

        // Return the data stored in the fractional node
        return ans.data;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(7);
        head.next.next = new Node(9);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);

        int k = 3;

        System.out.println(fractionalNode(head, k));
    }
}