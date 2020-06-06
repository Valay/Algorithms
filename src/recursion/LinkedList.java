package recursion;

public class LinkedList {

    static Node insertAtHead(Node temp_head, int new_value) {
        Node new_Node = new Node();
        new_Node.value = new_value;
        new_Node.next = (temp_head);
        (temp_head) = new_Node;

        return temp_head;
    }

    ;

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        // Empty Linked List
        Node head = null;

        // Linked List = 1->2->3->4->5
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        // Print the original Linked List
        System.out.println("Linked List: ");
        ll.print(head);

        // Print the reversed Linked List
        System.out.println(" ");
        System.out.println("Reversed Linked List: ");
        ll.print(ll.reverse(head));


        // Empty Linked List
        Node root = null;

        // Linked List = 1->2->3->4->5
        root = insertAtHead(root, 20);
        root = insertAtHead(root, 10);
        root = insertAtHead(root, 30);
        root = insertAtHead(root, 50);
        root = insertAtHead(root, 7);
        // Print the sum of a linked list
        System.out.println("");
        ll.print(root);
        System.out.println("Sum = " + ll.sum(root));
    }

    /**
     * Recursively reverse a linked list
     *
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        Node tmp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return tmp;
    }

    /**
     * Calculate the sum of the node values in the ll
     *
     * @param head
     * @return
     */
    public int sum(Node head) {
        if (head == null) {
            return 0;
        }

        return head.value + sum(head.next);
    }

    private void print(Node head) {
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.value + " ");
        }
    }

    // Linked List Node
    static class Node {
        int value;
        Node next;
    }
}
