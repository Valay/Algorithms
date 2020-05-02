package recursion;

/**
 * Implements following methods
 * <p>
 * 1) GCD - Greatest Common Divisor of two numbers
 * 2) isPrime - checks whether a number is a Prime Number
 * 3) Convert Decimal number to Binary number
 */
public class Numbers {

    public Numbers() {
    }

    public static void main(String[] args) {

        // Get Numbers object
        Numbers numbers = new Numbers();

        // GCD
        int x = 56;
        int y = 42;
        int result = numbers.gcd(x, y);
        System.out.println("The GCD of " + x + " and " + y + " is:");
        System.out.println(result);

        // Prime
        int input = 13;
        boolean result2 = numbers.isPrime(input, input / 2);

        // Print if the number is prime
        if (result2) {
            System.out.println(input + " is a prime number");
        }
        // Prints if the number is NOT a prime number
        else {
            System.out.println(input + " is NOT a prime number");
        }

        // Decimal to Binary
        int input3 = 19;
        int result3 = numbers.decimalToBinary(input3);
        System.out.println("The binary form of " + input3 + " is: " + result3);
    }

    /**
     * Computes the greatest common divisor between two numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public int gcd(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        }
        return gcd(num1, num2 - num1);
    }

    /**
     * Check whether a number is a prime number
     *
     * @param num
     * @param i
     * @return
     */
    public boolean isPrime(int num, int i) {
        if (i < 2) {
            return false;
        }

        if (i == 1) {
            return true;
        }

        if (num % i == 0) {
            return true;
        }

        return isPrime(num, i - 1);
    }

    /**
     * Converts a decimal number to binary number
     *
     * @param decimal
     * @return
     */
    public int decimalToBinary(int decimal) {
        if (decimal == 0) {
            return 0;
        }

        return decimal % 2 + 10 * decimalToBinary(decimal / 2);
    }
}
