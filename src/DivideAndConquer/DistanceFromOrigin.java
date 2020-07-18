package DivideAndConquer;

import output.OutputPrinter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistanceFromOrigin {
    static Comparator<Node> nodeComparator = new Comparator<Node>() {

        public int compare(Node a, Node b) {

            if (a.distance > b.distance) {
                return -1;
            } else if (a.distance < b.distance) {
                return 1;
            }
            return 0;
        }
    };

    public static void main(String[] args) {

        DistanceFromOrigin dfo = new DistanceFromOrigin();
        int[][] nums = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        OutputPrinter op = new OutputPrinter();
        op.print2DIntegerArray(dfo.kClosest(nums, k));


        String s = "+35-56*78";

        String[] tokens = s.split("(?<=[-+*/])|(?=[-+*/])", 2);
        op.printArray(tokens);
    }

    public int[][] kClosest(int[][] points, int K) {

        Queue<Node> maxHeap = new PriorityQueue<Node>(K, nodeComparator);

        for (int i = 0; i < points.length; i++) {
            double distance = eculideanDistanceFromOrigin(points[i][0], points[i][1]);
            Node newNode = new Node(distance, points[i][0], points[i][1]);
            if (maxHeap.size() >= K) {
                Node top = maxHeap.peek();
                if (top.distance > distance) {
                    maxHeap.poll();
                    maxHeap.add(newNode);
                }
            } else {
                maxHeap.add(newNode);
            }
        }

        int[][] array = new int[K][2];

        Iterator<Node> nodeIterator = maxHeap.iterator();
        int count = 0;
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            array[count][0] = node.x;
            array[count][1] = node.y;
            count++;
        }

        return array;


    }

    private double eculideanDistanceFromOrigin(int x, int y) {
        return Math.sqrt((x * x) + (y * y));
    }

    class Node {
        double distance;
        int x;
        int y;

        public Node(double distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }

}
