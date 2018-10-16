/*
*   Danny Luong
*/

/*
*  Return the number of all non-distinct occurrences of the words found in the 2D char array
*  horizontally, vertically or diagonally, and also the reverse in each direction.
*/

import java.io.*;
import java.util.*;

public class Puzzle {
    public static class PuzzleSolver
    {
        public static String[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};

        static boolean IsWord(String testWord)
        {
            if (Arrays.asList(DICTIONARY).contains(testWord))
                return true;
            return false;
        }

        public static int FindWords(char[][] puzzle){
            int count = 0;
            // Iterates through 2D array
            for(int row = 0; row < puzzle.length; row++) {
                for(int col = 0; col < puzzle[row].length; col++) {
                    String letter = String.valueOf(puzzle[row][col]);
                    // Checks if individual characters are in the DICTIONARY
                    if(IsWord(letter)) {
                        count++;
                    }
                    count += Horizontal(row, col, puzzle) + Vertical(row, col, puzzle) + Diagonal(row, col, puzzle);
                }
            }
            return count;
        }

        // Transverse 2D array Horizontally
        public static int Horizontal(int row, int col, char[][] puzzle) {
            int count = 0;
            String word = "";
            for(int i = 0; col+i < puzzle[row].length; i++) {
                // Builds string using each letter from starting character horizontally.
                word += puzzle[row][col+i];
                // Checks if string is in the DICTIONARY as long as the word length is not a single character
                if((IsWord(word) || IsWord(Reverse(word))) && word.length() > 1) {
                    count++;
                }
            }
            return count;
        }

        // Transverse 2D array Vertically
        public static int Vertical(int row, int col, char[][] puzzle) {
            int count = 0;
            String word = "";
            for(int i = 0; row+i < puzzle.length; i++) {
                // Builds string using each letter from starting character vertically
                word += puzzle[row+i][col];
                // Checks if string is in the DICTIONARY as long as the word length is not a single character
                if((IsWord(word) || IsWord(Reverse(word))) && word.length() > 1) {
                    count++;
                }
            }
            return count;
        }

        // Transverse 2D array Diagonally
        public static int Diagonal(int row, int col, char[][] puzzle) {
            int count = 0;
            String left = "";
            String right = "";
            // Transverse left diagonal
            for(int i = 0; row+i < puzzle.length && col-i > 0; i++) {
                // Builds string using each letter from starting character left diagonally
                // left i and down i of starting character
                left += puzzle[row+i][col-i];
                // Checks if string is in the DICTIONARY as long as the word length is not a single character
                if((IsWord(left) || IsWord(Reverse(left))) && left.length() > 1) {
                    count++;
                }
            }

            // Transverse right diagonal
            for(int i = 0; row+i < puzzle.length && col+i < puzzle[row].length; i++) {
                // Builds string using each letter from starting character left diagonally
                // right i and down i of starting character
                right += puzzle[row+i][col+i];
                // Checks if string is in the DICTIONARY as long as the word length is not a single character
                if((IsWord(right) || IsWord(Reverse(right))) && right.length() > 1) {
                    count++;
                }
            }
            return count;
        }

        // Reverse the string
        public static String Reverse(String word) {
            char[] reversed = new char[word.length()];
            for(int row = 0; row < word.length(); row++) {
                // Store characters from word in reversed by transversing reversed backwards
                reversed[word.length()-row-1] = word.charAt(row);
            }
            // Convert reversed to a string
            return new String(reversed);
        }
    }

    public static void main(String args[]) {

        char[][] words = {{'C','A','T'},
                            {'X','Z','T'},
                            {'Y','O','T'}};

        char[][] words2 = {{'C','A','T','A','P','U','L','T'},
                {'X','Z','T','T','O','Y','O','O'},
                {'Y','O','T','O','X','T','X','X'}};


        System.out.println(PuzzleSolver.FindWords(words));
        System.out.println(PuzzleSolver.FindWords(words2));
    }
}
