package recursion;

/**
 * Implements various algorithms on arrays recursively
 * 1. First occurrence of number in an array
 * 2. Invert an array
 * 3. Check if array is a palindrome
 * 4. Recursively sort an array - bubble sort
 */
public class Arrays {

    public static void main(String[] args) {
        Arrays arrays = new Arrays();


        // First occurrence of number in an array
        int[] array = {2, 9, 4, 1, 7, 8, 5};
        arrays.printArray(array);
        int num = 3;
        int result = arrays.firstOccurrence(array, num);
        System.out.println("The first occurrence of the number " + num + " is at index: " + result);


        // Invert an array
        arrays.invertArray(array, 0, array.length - 1);
        arrays.printArray(array);

        // Check of array is a palindrome
        System.out.println("\nIs Palindrome? " + arrays.palindrome(array, 0, array.length - 1));
        int[] array2 = {1, 2, 3, 4, 3, 2, 1};
        arrays.printArray(array2);
        System.out.println("Is Palindrome? " + arrays.palindrome(array2, 0, array2.length - 1));
        int[] array3 = {1, 2, 3, 3, 2, 1};
        arrays.printArray(array3);
        System.out.println("Is Palindrome? " + arrays.palindrome(array3, 0, array3.length - 1));

        // recursively sort array - bubble sort
        arrays.printArray(array);
        arrays.sort(array, 0);
        System.out.println("Sorted array:");
        arrays.printArray(array);

        int[] array4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        arrays.printArray(array4);
        arrays.sort(array4, 0);
        System.out.println("Sorted array:");
        arrays.printArray(array4);

    }

    /**
     * Finds the first occurence of i in the given array starting at index 0
     * returns -1 if i is not present in the array
     *
     * @param arr
     * @param i
     * @return
     */
    public int firstOccurrence(int[] arr, int i) {
        return firstOccurrence(arr, i, 0);
    }

    private int firstOccurrence(int[] a, int i, int index) {
        if (index >= a.length) {
            return -1;
        }

        if (a[index] == i) {
            return index;
        }

        return firstOccurrence(a, i, ++index);
    }

    /**
     * Reverse the array using recursion
     *
     * @param a
     */
    public void invertArray(int[] a, int i, int j) {
        if (i >= j) {
            return;
        }

        // swap elements at position i and j
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        invertArray(a, i + 1, j - 1);
    }

    /**
     * Check if given array is a palindrome
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    public boolean palindrome(int[] array, int i, int j) {
        if (i >= j) {
            return true;
        }

        return array[i] == array[j] && palindrome(array, i + 1, j - 1);
    }

    /**
     * Recursive implementation of bubble sort
     *
     * @param arr
     * @param index
     */
    public void sort(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        sort(arr, index + 1);
    }

    // Helper to print array
    private void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }
}
