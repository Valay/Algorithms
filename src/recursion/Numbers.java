package recursion;

public class Numbers {

    public Numbers() {
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
