/* WordTester.java
* Author: Shikhar Bakhda
* UNI: ssb2189
* 
* This file contains a tester that tests out some functions from the
* the WordLists class, producing files for each of the outputs from 
* the WordLists class methods. It uses the file dictionary.txt
*/

// Importing useful class and methods
import java.util.*;  //For Scanner
import java.io.*;	//For I/O classes


// Tester class
public class WordTester {     
	public static void main(String[] args) {

		// Declaring variables which will be used below
		String fileName = "dictionary.txt"; //Initialising fileName
		PrintWriter out; // Object that will write into files
		String[] wordList; // An array that contains outputs of methods
		int i; // Iteration variable

		// The code in this block might through errors. Hence we try it. 
		try{

			// Initialising object of class WordLists, passing fileName
			WordLists words = new WordLists(fileName);

			// Testing the lengthN method by creating file 
			// that contains list of 6-lettered words		
			System.out.println("\nGetting 6-lettered words...");
			// Creating/writing new file
			out = new PrintWriter("words_sizeN.txt"); 
			wordList = words.lengthN(6); 
			// Printing array elements into new lines
			for(i=0; i < wordList.length; i++) { 
				out.println(wordList[i]);
			}
		    out.close(); // Closing file
		    System.out.println("lengthN method tested in words_sizeN.txt\n");


		    // Testing the startsWith method by creating file 
			// that contains list of 5-lettered words starting with z	
			System.out.println("Getting 5-lettered words starting with z..");
			// Creating/writing new file
		    out = new PrintWriter("words_startsWith.txt");
			wordList = words.startsWith(5, 'z');
			// Printing array elements into new lines
			for(i=0; i < wordList.length; i++) {
				out.println(wordList[i]);
			}
		    out.close(); // Closing file
		    System.out.println("startsWith method tested in" + 
		    			" words_startsWith.txt\n");


		    // Testing the startsWith method by creating file 
			// that contains list of 5-lettered words containing z	
			System.out.println("Getting 5-lettered words containing z...");
			// Creating/writing new file
		    out = new PrintWriter("words_containsLetter.txt");
			wordList = words.containsLetter(5, 'z');
			// Printing array elements into new lines
			for(i=0; i < wordList.length; i++) {
				out.println(wordList[i]);
			}
		    out.close(); // Closing file
		    System.out.println("containsLetter method" + 
		    			" tested in 'words_containsLetter.txt'.\n");


		    // Testing the vowelHeavy method by creating file 
			// that contains list of 8-letter words with 5 vowels	
			System.out.println("Getting 8-lettered words with 5 vowels...");
			// Creating/writing new file
		    out = new PrintWriter("words_vowelHeavy.txt");
			wordList = words.vowelHeavy(8, 5);
			// Printing array elements into new lines
			for(i=0; i < wordList.length; i++) {
				out.println(wordList[i]);
			}
		    out.close(); // Closing file
		    System.out.println("vowelHeavy method tested" +
		    			" in 'words_vowelHeavy.txt'.\n");


		    // Testing the multiLetter method by creating file 
			// that contains list of words containing 5 a's	
			System.out.println("Getting words containing 5 a's...");
			// Creating/writing new file
		    out = new PrintWriter("words_multiLetter.txt");
			wordList = words.multiLetter(5, 'a');
			// Printing array elements into new lines
			for(i=0; i < wordList.length; i++) {
				out.println(wordList[i]);
			}
		    out.close(); // Closing file
		    System.out.println("multiLetter method tested" +
		    			" in 'words_multiLetter.txt'.\n");
    	}

    	// Catching FileNotFoundException exceptions if thrown
    	catch(FileNotFoundException exception) {
    		System.out.println("File '" + fileName + "' does not exist");
    	}

    	// Catching IOException exceptions if thrown
    	catch(IOException exception) {
    		System.out.println("Unable to open file '" + fileName + "'");
    	}

    	// Catching any other exception that was found, so that program
    	// 		terminates gracefully no matter what error is thrown
    	catch (Exception exception) {
		   System.out.println(exception.getMessage());
		}

    }
}