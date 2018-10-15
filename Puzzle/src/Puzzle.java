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
        public static string[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};

        static bool IsWord(string testWord)
        {
            if (Arrays.asList(DICTIONARY).Contains(testWord))
                return true;
            return false;
        }

        public static int FindWords(char[][] puzzle){

            return 0; // TODO
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

        // System.out.println(PuzzleSolver.FindWords(words));
    }
}
