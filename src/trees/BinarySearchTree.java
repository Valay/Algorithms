package trees;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    Node<T> root;

    public BinarySearchTree() {
        super();
    }

    public void validate() {

    }

    public void insert(T value) {
        if (root == null) {
            root = createNode(value);
            return;
        }
        insert(root, value);
    }

    private void insert(Node<T> head, T value) {

        if (value.compareTo(head.value) >= 0) {
            if (head.right == null) {
                head.right = createNode(value);
                return;
            } else {
                insert(head.right, value);
            }
        } else {
            if (head.left == null) {
                head.left = createNode(value);
                return;
            } else {
                insert(head.left, value);
            }
        }

    }

    public void insertIteratively(T value) {
        if (root == null) {
            root = createNode(value);
            return;
        }

        Node<T> head = root;
        while (head != null) {
            if (head.value.compareTo(value) >= 0) {
                if (head.left == null) {
                    head.left = createNode(value);
                    break;
                }
                head = head.left;
            } else {
                if (head.right == null) {
                    head.right = createNode(value);
                    break;
                }
                head = head.right;
            }
        }
    }

    public boolean delete(T value) {
        return false;
    }

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(Node<T> cur, T value) {
        if (cur == null) {
            return false;
        }

        int c = value.compareTo(cur.value);
        if (c == 0) {
            return true;
        } else if (c < 0) {
            return search(cur.left, value);
        } else {
            return search(cur.right, value);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> createNode(T value) {
        return new Node<T>(value);
    }

    // Prints in-order traversal
    public void print() {
        printTree(root);
    }

    //Just for Testing purpose
    private void printTree(Node<T> current) {
        if (current == null) return;

        printTree(current.left);
        System.out.print(current.value + ",");
        printTree(current.right);

    }
}
