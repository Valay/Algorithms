package recursion;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implements following methods
 * 1) Remove adjacent duplicates in a string
 * 2) Merge two strings alphabetically
 * 3) Total Vowels in a string
 * 4) Print all string permutations - with Duplicates
 * 5) Print all string permutations - without Duplicates
 * 6) isPalindrome - Check if a String is palindrome
 */
public class Strings {

    int pc = 0;

    public static void main(String[] args) {

        Strings strings = new Strings();

        // Remove adjacent duplicates
        String input1 = "Thiss iiss aa teesstt";
        System.out.println("Original string: " + input1);
        String output = strings.removeDuplicatesInAString(input1);
        System.out.println("String after: " + output);

        // merge two strings alphabetically
        String one = "ace";
        String two = "cnt";
        String answer = strings.alphabeticMerge(one, two);
        System.out.println(answer);

        // Total Vowels
        String stringwithVowels = "This is 5 vowels string";
        System.out.println("Number of vowels in \"" + stringwithVowels +
                "\" is " + strings.totalVowels(stringwithVowels));

        // Print all string permutations - With duplicates
        strings.printAllPermutations("caned".toCharArray(), 5);
        System.out.println("Number of permutations : " + strings.pc);

        strings.pc = 0;
        // Print all string permutations - Without duplicates
        strings.printAllPermutationsNoDuplicates("canned".toCharArray());
        System.out.println("Number of permutations : " + strings.pc);

        // is the string a palindrome
        String palin = "AMANAPLANACANALPANAMA";
        String palin2 = "ABCBA";
        String palin3 = "ABBA";
        String nonPalin = "PALIN";
        System.out.println(palin + " is Palindrome?" + strings.isPalindrome(palin));
        System.out.println(palin2 + " is Palindrome?" + strings.isPalindrome(palin2));
        System.out.println(palin3 + " is Palindrome?" + strings.isPalindrome(palin3));
        System.out.println(nonPalin + " is Palindrome?" + strings.isPalindrome(nonPalin));

    }


    /**
     * Removes adjacent duplicate characters in a String
     * Helllo Woorld -> Helo World
     *
     * @param s
     * @return
     */
    public String removeDuplicatesInAString(String s) {
        if (s.length() <= 1) {
            return s;
        }

        if (s.substring(0, 1).equals(s.substring(1, 2))) {
            return removeDuplicatesInAString(s.substring(1));
        }
        return s.substring(0, 1) + removeDuplicatesInAString(s.substring(1));
    }

    /**
     * Merges two strings alphabetically
     * The code assumes that the strings are already sorted alphabetically
     *
     * @param a
     * @param b
     * @return
     */
    public String alphabeticMerge(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }

        if (b.isEmpty()) {
            return a;
        }

        if (a.charAt(0) <= b.charAt(0)) {
            return a.charAt(0) + alphabeticMerge(a.substring(1), b);
        } else {
            return b.charAt(0) + alphabeticMerge(a, b.substring(1));
        }
    }

    public int totalVowels(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        switch (text.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return 1 + totalVowels(text.substring(1));
            default:
                return totalVowels(text.substring(1));
        }
    }


    /**
     * Print all the permutations of a String - with duplicates
     *
     * @param s
     */
    public void printAllPermutations(char[] s, int len) {
        if (len == 1) {
            pc++;
            System.out.println(Arrays.toString(s));
        }

        for (int i = 0; i < len; i++) {
            //swap last char with iTH char
            swap(s, i, len - 1);
            printAllPermutations(s, len - 1);
            swap(s, i, len - 1);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    /**
     * Prints all permutations of a string - no duplicates
     * https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=1179s
     *
     * @param s
     */
    public void printAllPermutationsNoDuplicates(char[] s) {
        //Sorted Map by Natural Ordering
        Map<Character, Integer> counter = new TreeMap<>();
        for (char c : s) {
            counter.compute(c, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }

        char[] str = new char[counter.size()];
        int[] count = new int[counter.size()];

        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            str[cnt] = entry.getKey();
            count[cnt] = entry.getValue();
            cnt++;
        }

        char[] result = new char[counter.size()];
        printAllPermutationsHelper(str, count, result, 0);
    }

    private void printAllPermutationsHelper(char[] s, int[] count, char[] result, int level) {
        if (level == result.length) {
            printPermutation(result);
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            result[level] = s[i];
            count[i]--;
            printAllPermutationsHelper(s, count, result, level + 1);
            count[i]++;
        }
    }

    private void printPermutation(char[] result) {
        System.out.println(Arrays.toString(result));
        pc++;
    }

    /**
     * Check if the string is a palindrome
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        return s.charAt(0) == s.charAt(s.length() - 1)
                && isPalindrome(s.substring(1, s.length() - 1));
    }

}
