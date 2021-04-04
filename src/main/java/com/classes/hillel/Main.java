package main.java.com.classes.hillel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//        boolean c1 = true & false & true;
//        boolean c2 = true && false && true;
//        SOLID

public class Main {
    static String[] alphabet = {"a", "b", "c", "d",
            "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"};
    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] fullAlphabet = completeAlphabet();

        System.out.println("Press shift number, please!");
        int number = getShiftFromConsole();

        System.out.println("Please enter text to encode:");
        String enteredText = getEncodingTextFromConsole();

        String encryptedText = encrypt(enteredText,
                fullAlphabet, number);

        System.out.println(encryptedText);
    }

    private static int getShiftFromConsole() {
        String text = "";
        try {
            text = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (text == null || text.isEmpty()) {
            text = "0";
        }

        int number = 0;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return number;
    }

    private static String getEncodingTextFromConsole() {
        String encodingText = "";
        try {
            encodingText = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return encodingText;
    }

    private static String[] completeAlphabet() {
        String [] alphabetWithCapitalLetters
                = fillCapitalLetters();

        String [] alphabetWithSpecialSymbols
                = fillSpecialSymbols(alphabetWithCapitalLetters);

        return alphabetWithSpecialSymbols;
    }

    private static String[] fillSpecialSymbols(String [] newAlphabet) {
        //Some actions
        return newAlphabet;
    }

    private static String[] fillCapitalLetters() {
        String [] newAlphabet = new String[alphabet.length * 2];

        for (int i = 0; i < alphabet.length; ++i) {
            newAlphabet[i] = alphabet[i];
        }

        for (int i = alphabet.length; i < newAlphabet.length; ++i) {
            newAlphabet[i] = alphabet[i - alphabet.length].toUpperCase();
        }
        return newAlphabet;
    }

    private static String encrypt(String word,
                                  String[] alphabet,
                                  int shift) {
        String encrypted = "";
        for (int i = 0; i < word.length(); i++) {
            int index = findIndex(alphabet, word.charAt(i));
            if (index + shift > alphabet.length - 1) {
                int innerIndex = (index + shift) - alphabet.length;
                index = innerIndex - 1;
            }
            encrypted = encrypted.concat(alphabet[index + shift]);
        }
        return encrypted;
    }

    private static int findIndex(String[] alphabet,
                                 char letter) {
        int index = 0;
        for (int i = 0; i < alphabet.length; i++) {
            String ch = alphabet[i];
            if (ch.equals(String.valueOf(letter))) {
                return i;
            }
        }
        return index;
    }
}
