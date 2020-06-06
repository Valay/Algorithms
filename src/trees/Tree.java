package trees;

public class Tree {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(1);
        bst.insert(5);
        bst.insertIteratively(2);
        bst.insert(9);
        bst.insert(6);
        bst.insertIteratively(3);
        bst.insert(7);

        bst.print();

        System.out.println("Search 8 " + bst.search(8));
        System.out.println("Search 2 " + bst.search(2));
        System.out.println("Search 9 " + bst.search(9));
        System.out.println("Search 3 " + bst.search(3));
        System.out.println("Search 1 " + bst.search(1));


    }
}
