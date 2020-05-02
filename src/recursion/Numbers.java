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
}
