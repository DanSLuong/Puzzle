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
        static int count = 0;
        static String word = "";

        static boolean IsWord(String testWord)
        {
            if (Arrays.asList(DICTIONARY).contains(testWord))
                return true;
            return false;
        }

        public static int FindWords(char[][] puzzle){
            for(int row = 0; row < puzzle.length; row++) {
                for(int col = 0; col < puzzle[row].length; col++) {
                    word = String.valueOf(puzzle[col][row]);
                    // Checks if individual characters are in the DICTIONARY
                    if(IsWord(word))
                        count++;
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
