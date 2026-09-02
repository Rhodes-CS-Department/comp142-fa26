package lab01sol;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Wheel of Fortune is a classic TV show.
 * Contestants must guess letters to fill in a phrase.
 */
public class WheelOfFortune {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");

        // read a line from the scanner, convert it to a char array
        char[] secretArray = scanner.nextLine().toCharArray();

        // same length as secretArray, but letters replaced with `-`.
        char[] puzzleArray = makePuzzleArray(secretArray);

        while (true) {
            System.out.println();
            System.out.println("The puzzle is: " + charsToString(puzzleArray));

            // check if the puzzle is solved.
            if (Arrays.equals(puzzleArray, secretArray)) {
                break;
            }

            System.out.print("Guess a letter: ");
            char letter = scanner.nextLine().charAt(0); // read one character.
            int frequency = countLetter(secretArray, letter);
            System.out.println("The letter " + letter + " appears " + frequency + " times.");

            updatePuzzleArray(puzzleArray, secretArray, letter);
        }

        System.out.println("You win!");
    }

    /**
     * Convert a character array to a string.
     * @param arr an array of characters.
     * @return the corresponding string.
     */
    public static String charsToString(char[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }

        return str;
    }

    /**
     * Build a new character array that is the same length as secretArray:
     * - Each letter of `secretArray` corresponds to a `-` in the new array.
     * - Each space of `secretArray` corresponds to a space in the new array.
     * @param secretArray the secret array, set at the start of the game.
     * @return the puzzle array, with dashes in place of letters.
     */
    public static char[] makePuzzleArray(char[] secretArray) {
        char[] puzzleArray = new char[secretArray.length];

        for (int i = 0; i < puzzleArray.length; i++) {
            if (secretArray[i] == ' ') {
                puzzleArray[i] = ' ';
            } else {
                puzzleArray[i] = '-';
            }
        }

        return puzzleArray;
    }

    /**
     * Update `puzzleArray` by uncovering each hidden occurrence of `guess`.
     * @param puzzleArray the puzzle array, with dashes for unguessed chars.
     * @param secretArray the secret array, set at the start of the game.
     * @param guess the letter the player just guessed.
     */
    public static void updatePuzzleArray(char[] puzzleArray, char[] secretArray, char guess) {
        for (int i = 0; i < puzzleArray.length; i++) {
            if (secretArray[i] == guess) {
                puzzleArray[i] = guess;
            }
        }
    }

    /**
     * Count the number of times a letter appears in an array.
     * @param arr an array of letters.
     * @param letter the letter to count.
     * @return the number of occurrences of `letter` in `arr`.
     */
    public static int countLetter(char[] arr, char letter) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == letter) {
                count++;
            }
        }

        return count;
    }

}