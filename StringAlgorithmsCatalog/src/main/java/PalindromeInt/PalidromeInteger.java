package PalindromeInt;

import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insira um número inteiro: ");
            if (scanner.hasNextInt()) {
                System.out.println(isIntPalindrome(scanner.nextInt()));
            }
            throw new RuntimeException("Entrada inválida. Por favor, insira um número inteiro.");
        }
    }

    private static boolean isIntPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int originalValue = x;
        int reversedValue = 0;
        while (x != 0) {
            int digit = x % 10;
            reversedValue = reversedValue * 10 + digit;
            x /= 10;
        }
        return originalValue == reversedValue;
    }
}
