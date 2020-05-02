package recursion;

public class Main {

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
}
