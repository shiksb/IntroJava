RomanNumeralTester.java

	This class tests the RomanNumeral class by taking a user input, checking if it's valid (between 0 and 3999). It then passes this number to the RomanNumeral object when it is created. Finally, the roman numeral is printed by calling the getRoman function of the object. 

RomanNumeral.java

	This class converts the decimal number to its roman numeral. It has 1 instance variable, 'dec_num'. This is the value sent to the constructor. This class has 2 methods and a constructor: 

	1. The constructor RomanNumeral(int dec)

		The value sent by the user, 'dec', is copied into the instance variable 'dec_num'.

	2. The method String getRoman() 

		I identified that for every digit, the relevant information is simply its place (1,10,100,or 1000) and its value relative to 1, 4, 5, or 9 (since these numbers have distinct representations depending on the power of 10). The for loop takes a variable 'power' from 1000 down to 1 through the powers of 10. 

		Using a switch-case statement, the power is compared and the respective roman strings for 1, 4, 5, 9 are passed into another method called add_roman, described below. Exception: For thousands there's only 1, since numbers >=4000 are not valid, so "" is passed. 

	3. The method String add_roman()

		This method takes the parameters digit (value of one of the 4 digits), and the string representations for 1, 4, 5, and 9 for that particular power. It first checks if the value of the digit is 1, 4, 5, or 9. If it is, it concatenates that to a string 'roman', and then subtracts that value. Then it keeps adding I's or X's or C's or M's till the value of the digit becomes zero. 


Drunkard.java

	This class has 4 functions and a constructor that simulate and print various details of an innocent drunkard in New York City:

	1. The constructor Drunkard()

		The values sent by the user, 'x' and 'y' are copied into the variables for avenue, street, and the initial avenue and initial street as indicated by comments in the class.

	2. The method void step()

		This method moves the drunkard by one position (up, down, left, right) decided by a random function. The number generated is brought to a range of 1 to 4 (inclusive) and compared to the numbers 1 to 4. Depending on which number, it increments or decrements the street or avenue. 

	3. The method void fastForward(int steps)

		This method moves the drunkard by 'steps' number of steps, each step randomly. This is done by calling the step() method 'steps' number of times. 

	4. The method String getLocation()

		This method returns the current position, in x and y coordinates of the drunkard 

	5. The method int howFar()

		This method calculates and returns the distance, in blocks, the drunkard has travelled from the initial position the user entered. The distance is calculated using the formula given in the question. 

DrunkardTester.java

	This class is EXACTLY the same as the one the professor provided. 

