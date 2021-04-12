package main.java.com.classes.hillel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//        boolean c1 = true & false & true;
//        boolean c2 = true && false && true;
//        SOLID

public class Main {
    static String[] alphabet = {"z", "i", "c", "d",
            "r", "f", "g", "h", "b", "j", "k",
            "l", "m", "w", "o", "p", "q", "e",
            "s", "t", "u", "v", "n", "x", "y", "a"};
    static int counter = 0;

    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

//      ___________Spiting String and write to console__________________
        String s = "Hello! I am a little pony :)";
        splitStringAndWriteToConsole(s);


//      ___________Sorting array using standard methods_________________
        int[] myArray = new int[]{4, 7, 3, 0, 2};
        Arrays.sort(myArray);
        Arrays.sort(alphabet);

        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.toString(alphabet));


//      ___________Encoding String______________________________________
        String[] fullAlphabet = completeAlphabet();

        System.out.println("Enter shift number, please!");
        int number = getShiftNumberFromConsole();

        System.out.println("Please enter text to encode:");
        String enteredText = getEncodingTextFromConsole();

        String encryptedText = encrypt(enteredText,
                fullAlphabet, number);

        System.out.println(encryptedText);
    }

    private static void splitStringAndWriteToConsole(String s) {
        String[] array = s.split(" ");
        for (String s1 : array) {
            System.out.println(s1);
        }
    }

    private static String[] completeAlphabet() {
        String[] alphabetWithCapitalLetters
                = fillCapitalLetters();

        String[] alphabetWithSpecialSymbols
                = fillSpecialSymbols(alphabetWithCapitalLetters);

        return alphabetWithSpecialSymbols;
    }

    private static int getShiftNumberFromConsole() {
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

    private static String[] fillSpecialSymbols(String[] newAlphabet) {
        //Some actions
        return newAlphabet;
    }

    private static String[] fillCapitalLetters() {
        String[] newAlphabet = new String[alphabet.length * 2];

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

    private static void simpleSort(int[] arrayToSort) {
        boolean needToBeSorted = true;
        counter = 0;

        while (needToBeSorted) {
            needToBeSorted = false;

            for (int i = 1; i < arrayToSort.length; ++i) {
                if (arrayToSort[i - 1] > arrayToSort[i]) {
                    swap(arrayToSort, i - 1, i);
                    needToBeSorted = true;
                }
            }
        }

        System.out.println("Counts: " + counter);
        System.out.println(Arrays.toString(arrayToSort));
    }

    private static void selectionSort(int[] arrayToSort) {
        counter = 0;

        for (int i = 0; i < arrayToSort.length; ++i) {
            int tmp = i;
            for (int j = i; j < arrayToSort.length; ++j) {
                if (arrayToSort[j] < arrayToSort[tmp]) {
                    tmp = j;
                }
            }
            swap(arrayToSort, i, tmp);
        }

        System.out.println("Counts: " + counter);
        System.out.println(Arrays.toString(arrayToSort));
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;

        counter++;
    }
}
