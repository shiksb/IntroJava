//***********************
// RomanNumeralTester.java
// Written by Ethan Adams
// COMS W1004 Fall 2016
// Tester for RomanNumeral
//***********************

import java.util.Scanner;

public class RomanNumeralTester
{
	public static void main(String[] args)
	{
		// get a number from the user
		Scanner user = new Scanner(System.in);
		System.out.print("Kindly enter a number: ");
		int num = user.nextInt();

		RomanNumeral r = new RomanNumeral(num);

		// print out the result in roman numerals
		System.out.println("That's " + r.getRoman() + 
			" in Roman numerals!");
	}
}
