package trees;

public class BinaryTree<T> {

    public BinaryTree() {
    }

    class Node<T> {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
