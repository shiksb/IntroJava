/* WordLists.java
* Author: Shikhar Bakhda
* UNI: ssb2189
* 
* This file contains a class WordLists that contains an arraylist of
* words that are valid in the Scrabble dictionary and methods to help 
* a Scrabble player.
*/

// Importing useful class and methods
import java.util.*;  //For Scanner
import java.io.*;	//For I/O classes


// Class WordLists, containing methods to help scrabble players
public class WordLists {
	
	// the words arraylist will contain ALL words in dictionary.txt
	private ArrayList<String> words = new ArrayList<String>(); 


	// This constructor reads from fileName & populates the words arraylist
	// There might be an error while scanning the file if it doesn't exist
	// 		hence we include 'throws FileNotFoundException'
	public WordLists(String fileName) throws FileNotFoundException, 
													IOException {
		File inputFile = new File(fileName);
		Scanner in = new Scanner(inputFile);
        while (in.hasNextLine()) { 
			words.add(in.nextLine());
		}
		in.close();
	}


	// This method returns an array of words of length n
	public String[] lengthN(int n) {
		// wordsNlist is an arraylist since its size is variable
		ArrayList<String> wordsNlist = new ArrayList<String>();
		// Iterating through all words and populating wordsNlist
		for(int x = 0; x < words.size(); x++) {
			if(words.get(x).length() == n) {
				wordsNlist.add(words.get(x));
			}
		}
		// Returning the array of words of size n
		return(wordsNlist.toArray(new String[wordsNlist.size()]));
	}


	// This method returns an array of words of length n
	// 		starting with firstLetter
	public String[] startsWith(int n, char firstLetter) {
		// wordsNlist is an arraylist since its size is variable
		ArrayList<String> wordsNlist = new ArrayList<String>();
		// Creating an array of words of length n using the lengthN method
		String[] wordsN = lengthN(n);
		// Iterating through wordsN and populating wordsNlist
		for(int i = 0; i < wordsN.length; i++) {
			// Checking if the word begins with firstLetter
			if(wordsN[i].charAt(0) == firstLetter) {
				wordsNlist.add(wordsN[i]);
			}
		}
		// Returning an array of words of size n starting with firstLetter
		return(wordsNlist.toArray(new String[wordsNlist.size()]));
	}


	// This method returns an array of words of length n 
	//		containing but not begninning with char included
	public String[] containsLetter(int n, char included) {
		// wordsNlist is an arraylist since its size is variable
		ArrayList<String> wordsNlist = new ArrayList<String>();
		// Creating an array of words of length n using the lengthN method
		String[] wordsN = lengthN(n);
		// Iterating through wordsN and populating wordNlist
		for(int i = 0; i < wordsN.length; i++) {
			// Finding char included in the string, starting index 1
			// 		checking if string doesn't start with char included
			if(wordsN[i].indexOf(included,1) != -1 && 
				wordsN[i].charAt(0) != included) {
				wordsNlist.add(wordsN[i]);
			}
		}
		// Returning an array of words of size n including char included
		return(wordsNlist.toArray(new String[wordsNlist.size()]));
	}


	// This method returns an array of words of length n with m vowels
	public String[] vowelHeavy(int n, int m) {
		// wordsNlist is an arraylist since its size is variable
		ArrayList<String> wordsNlist = new ArrayList<String>();
		// Creating an array of words of length n using the lengthN method
		String[] wordsN = lengthN(n);
		// Iterating through wordsN and populating wordNlist
		for(int i = 0; i < wordsN.length; i++) {
			// Resetting count to 0 after every word is processed
			int count = 0;
			// Iterating through every letter of the word to vowel check
			for(int letter = 0; letter < wordsN[i].length(); letter++) {
				if( wordsN[i].charAt(letter) == 'a' || 
                	wordsN[i].charAt(letter) == 'e' || 
                	wordsN[i].charAt(letter) == 'i' || 
                	wordsN[i].charAt(letter) == 'o' || 
                	wordsN[i].charAt(letter) == 'u' ) {
                		count++; // Incrementing the count by 1 if vowel
                }
            }
            // Checking if the count of vowels is at least m 
			if(count >= m) {
				wordsNlist.add(wordsN[i]);
			}
		}
		// Returning array of words of length n with at least m vowels
		return(wordsNlist.toArray(new String[wordsNlist.size()]));
	}


	// This method returns an array of words containing at least m
	//		instances of the letter included
	public String[] multiLetter(int m, char included){
		// wordsNlist is an arraylist since its size is variable
		ArrayList<String> wordsNlist = new ArrayList<String>();
		// Iterating through every word in the arraylist words
		for(int i = 0; i < words.size(); i++) {
			// Resetting the count to 0 after every word is processed
			int count = 0;
			// Iterating through every letter in the word
			for(int letter = 0; letter < words.get(i).length(); letter++) {
				// Checking if the letter is char included 
				if( words.get(i).charAt(letter) == included) {
                	count++; // Incrementing the count by 1 if it's included
				}
			}
			// Checking if the count is at least m
			if(count >= m) {
				wordsNlist.add(words.get(i));
			}
		}
		// Returning an array of words containing at least m instances of 
		// 		char included
		return(wordsNlist.toArray(new String[wordsNlist.size()]));
	}


}