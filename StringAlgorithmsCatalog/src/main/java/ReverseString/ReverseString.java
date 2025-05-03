package ReverseString;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insira uma String:");
            System.out.println(reverseStringWithRecursion(scanner.nextLine()));
        }
    }

    public static String reverseStringWithRecursion(String str) {
        if (str.isEmpty()) return str;
        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }

    public static String reverseStringWithIteration(String str) {
        String reversedString = new String();
        for (int i = 1; i <= str.length(); i ++) {
            char lastChar = str.charAt(str.length() - i);
            reversedString = reversedString + lastChar;
        }
        return reversedString;
    }
}
