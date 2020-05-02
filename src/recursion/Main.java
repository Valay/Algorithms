package recursion;

public class Main {

    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        int x = 56;
        int y = 42;
        int result = numbers.gcd(x, y);
        System.out.println("The GCD of " + x + " and " + y + " is:");
        System.out.println(result);
    }
}
