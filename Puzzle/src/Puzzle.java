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

        // Global variables
        static String word = "";

        static boolean IsWord(String testWord)
        {
            if (Arrays.asList(DICTIONARY).contains(testWord))
                return true;
            return false;
        }

        public static int FindWords(char[][] puzzle){
            int count = 0;
            for(int row = 0; row < puzzle.length; row++) {
                for(int col = 0; col < puzzle[row].length; col++) {
                    String letter = String.valueOf(puzzle[col][row]);
                    // Checks if individual characters are in the DICTIONARY
                    if(IsWord(letter)) {
                        count++;
                    }
                }
            }
            return count + Horizontal(puzzle);
        }

        // Transverse 2D array Horizontally
        public static int Horizontal(char[][] puzzle) {
            int count = 0;
            for(int row = 0; row < puzzle.length; row++) {
                for(int col = 0; col < puzzle[row].length; col++) {
                    for(int i = 0; i < puzzle[row].length && col+i < puzzle[row].length; i++) {
                        // transverse each letter from starting character horizontally.
                        word += puzzle[row][col+i];
                        // Checks if string is in the DICTIONARY as long as the word length is not a single character
                        if(IsWord(word) && word.length() > 1) {
                            System.out.println(word);
                            count++;
                        }
                    }
                }
            }
            return count;
        }


    }

    public static void main(String args[]) {
        char[][] words = {{'C','A','T'},
                            {'X','Z','T'},
                            {'Y','O','T'}};

        /*
        char[][] words = {{'C','A','T','A','P','U','L','T'},
                {'X','Z','T','T','O','Y','O','O'},
                {'Y','O','T','O','X','T','X','X'}};
        */

        System.out.println(PuzzleSolver.FindWords(words));
    }
}
