public class IntNode {
    int data;
    IntNode next;

    public IntNode(int data) {
        this.data = data;
    }

    public static int countNodes(IntNode head) {
        if (head.next == null) {
            return 1;
        }
        return 1 + countNodes(head.next);
    }

    public static void main(String[] args) {
        // Code to make the first example list: 4 -> 2 -> null
        // Make the nodes
        IntNode head1 = new IntNode(4);
        IntNode A = new IntNode(2);
        // Make the connections
        head1.next = A;

        // Code to make the second example list: 3 -> 10 -> 2 -> null
        // Make the nodes
        IntNode head2 = new IntNode(3);
        IntNode X = new IntNode(10);
        IntNode Y = new IntNode(2);
        // Make the connections
        head2.next = X;
        X.next = Y;

        // Test the countNodes function
        System.out.println(countNodes(head1)); // 2
        System.out.println(countNodes(head2)); // 3
    }
}
