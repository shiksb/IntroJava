//***********************
// RomanNumeral.java
// Written by Ethan Adams
// COMS W1004 Fall 2016
// Converts decimal numbers to Roman Numerals.
//***********************

public class RomanNumeral
{
	private int decimal;

	public RomanNumeral(int d)
	{
		decimal = d;
	}

	// function to go from decimal to roman
	// the value of n is modified according to what we can substract from it
	// we have to take into account 9s and 4s as they are special
	public String getRoman()
	{
		String roman = "";
		while (decimal > 0)
		{
			if (decimal >= 1000)
			{
				decimal -= 1000;
				roman += "M";
			}
			else if (decimal >= 900) 
			{
				decimal -= 900;
				roman += "CM";
			}
			else if (decimal >= 500)
			{
				decimal -= 500;
				roman += "D";
			}
			else if (decimal >= 400)
			{
				decimal -= 400;
				roman += "XD";
			}
			else if (decimal >= 100)
			{
				decimal -= 100;
				roman += "C";
			}
			else if (decimal >= 90)
			{
				decimal -= 90;
				roman += "XC";
			}
			else if (decimal >= 50)
			{
				decimal -= 50;
				roman += "L";
			}
			else if (decimal >= 40)
			{
				decimal -= 40;
				roman += "XL";
			}
			else if (decimal >= 10)
			{
				decimal -= 10;
				roman += "X";
			}
			else if (decimal >= 9)
			{
				decimal -= 9;
				roman += "IX";
			}
			else if (decimal >= 5)
			{
				decimal -= 5;
				roman += "V";
			}
			else if (decimal >= 4)
			{
				decimal -= 4;
				roman += "IV";
			}
			else if (decimal >= 1)
			{
				decimal -= 1;
				roman += "I";
			}
		}
		return roman;
	}
}