package PalidromeAnalysis;

import ReverseString.ReverseString;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.Scanner;

public class PalidromeAnalysis {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insira uma String:");
            System.out.println(verifyPalindrome(scanner.nextLine()));
        }
    }

    public static String normalizeString(String str) {
        // Converte para minúsculas
        String normalized  = str.toLowerCase();

        // Normaliza e remove acentos
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        normalized = pattern.matcher(normalized).replaceAll("");

        // Remove espaços
        normalized = normalized.replaceAll("\\s+", "");

        return normalized;
    }

    public static String verifyPalindrome(String str) {
        String strNormalized = normalizeString(str);
        String reversedName = ReverseString.reverseStringWithRecursion(strNormalized);
        if (strNormalized.equals(reversedName)) {
            return (String.format("%s é um palindromo.", str));
        }
        return (String.format("%s não é um palindromo.", str));
    }
}