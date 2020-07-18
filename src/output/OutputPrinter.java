package output;

public class OutputPrinter {

    public void print2DIntegerArray(int[][] points) {
        System.out.println("[ ");
        for (int i = 0; i < points.length; i++) {
            System.out.print("[");
            for (int j = 0; j < points[0].length; j++) {
                System.out.print(" " + points[i][j] + ",");
            }
            System.out.print("]\n");
        }
        System.out.println("\n ]");
    }

    public void printArray(String[] values) {
        System.out.println("[ ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + "  ");
        }
        System.out.println("\n ]");
    }
}
