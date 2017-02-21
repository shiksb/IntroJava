//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//  Taken from 1004 spring 2014 solutions
//
//**************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordLists {
    ArrayList<String> dictList;

    /**
     * A constructor that takes the name of the dictionary file as the only
     * parameter.
     * @param fileName the name of the file
     */
    public WordLists(String fileName) throws FileNotFoundException {
        dictList = new ArrayList<String>();
        File inFile = new File(fileName);
        Scanner in = new Scanner(inFile);
        while (in.hasNextLine()) {
            dictList.add(in.nextLine());
        }
    }

    /**
     * Finds all the words of length n
     * @param n length of word to find
     * @return an array of Strings of length n.
     */
    public String[] lengthN(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n is less than 0");
        }
        ArrayList<String> al = new ArrayList<String>();
        for (String word : dictList) {
            if (word.length() == n) {
                al.add(word);
            }
        }
        return al.toArray(new String[al.size()]);
    }

    /**
     * Finds all the words starting with a specified letter
     * @param n length of word to find
     * @param firstLetter the letter that the words start with
     * @return an array of Strings of length n that starts with firstLetter
     */
    public String[] startsWith(int n, char firstLetter) {
        if (n < 0) {
            throw new IllegalArgumentException("n is less than 0");
        }

        if (!Character.isLetter(firstLetter)) {
            throw new IllegalArgumentException("Char input is not a letter!");
        }

        ArrayList<String> al = new ArrayList<String>();
        for (String word : dictList) {
            if (word.length() == n && word.charAt(0)==firstLetter) {
                al.add(word);
            }
        }
        return al.toArray(new String[al.size()]);
    }

    /**
     * Finds all the words starting with a specified letter
     * @param n length of word to find
     * @param included the letter that the words contain
     * @return an array of Strings of length n containing the letter included
     *         but not beginning with it.
     */
    public String[] containsLetter(int n, char included) {
		if (n < 0) {
			throw new IllegalArgumentException("n is less than 0");
		}

        if (!Character.isLetter(included)) {
            throw new IllegalArgumentException("Char input is not a letter!");
        }

        ArrayList<String> al = new ArrayList<String>();
        for (String word : dictList) {
            if (word.length() == n && word.charAt(0) != included &&
                word.matches(".*[" + included + "].*")) {
                al.add(word);
            }
        }
        return al.toArray(new String[al.size()]);
    }

    /**
     * Finds all the words starting with a specified letter
     * @param n length of word to find
     * @param m the number of vowel the words have to contain
     * @return an array of Strings of length n containing at least m vowels.
     */
    public String[] vowelHeavy(int n, int m) {
		if (n < 0) {
			throw new IllegalArgumentException("n is less than 0");
		}

		if (m < 0) {
			throw new IllegalArgumentException("m is less than 0");
		}

        ArrayList<String> al = new ArrayList<String>();
        for (String word : dictList) {
            if (word.length() == n) {
                int count = 0;
                for (char c : word.toCharArray()) {
                    if (c=='a' || c=='e'|| c=='i'|| c=='o'||c=='u') {
                        count++;
                    }
                }
                if (count >= m) {
                    al.add(word);
                }
            }
        }
        return al.toArray(new String[al.size()]);
    }

    /**
     * Finds all the words starting with a specified letter
     * @param m the number of vowel the words have to contain
     * @param included the letter that the words contain
     * @return an array of Strings with at least m occurrences of the letter
     *         included.
     */
    public String[] multiLetter(int m, char included) {
        if (m < 0) {
            throw new IllegalArgumentException("m is less than 0");
        }

        if (!Character.isLetter(included)) {
            throw new IllegalArgumentException("Char input is not a letter!");
        }

        ArrayList<String> al = new ArrayList<String>();
        for (String word : dictList) {
            int count = 0;
            for (char c : word.toCharArray()) {
                if (c==included) {
                    count++;
                }
            }
            if (count >= m) {
                al.add(word);
            }
        }
        return al.toArray(new String[al.size()]);
    }
}
