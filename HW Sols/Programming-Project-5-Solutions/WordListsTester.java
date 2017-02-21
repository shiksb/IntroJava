//*************************************
//
//  WordListsTester.java
//
//  Test Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//  Taken from 1004 spring 2014 solutions
//
//**************************************

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class WordListsTester {
	
	public static void main(String[]args)  {
		WordLists wl;
		try {
			 wl = new WordLists("dictionary.txt");
				
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, file not found\n");
			return;
		}
		
		try {
			printList(wl.lengthN(9),"lengthOutput.txt");
			printList(wl.startsWith(4, 'z'),"startsOutput.txt");
			printList(wl.containsLetter(5, 'q'),"containsOutput.txt");
			printList(wl.vowelHeavy(3, 0),"vowelOutput.txt");
			printList(wl.multiLetter(2, 'u'),"multiOutput.txt");
		} catch (FileNotFoundException e) {
				System.out.println("Couldn't create output file\n");
		}
	}
	
	public static void printList(String[] array, String fileName)
		throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(fileName); 
		writer.write(Arrays.toString(array) + "\n");
		writer.close();
		System.out.println(fileName + " created (" + array.length + " items).");
		
	}

}