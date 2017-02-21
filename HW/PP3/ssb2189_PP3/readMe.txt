Zipcode.java

	This class is designed to convert a given zipcode to its barcode, and barcode to its zipcode. 
	In summary,
		It has 3 instance variables:

			1. String barcode: contains the string version of barcode
			2. String zipcode: contains the string version of zipcode
			3. int zip_num: contains the integer version of zip_num. Defined within constructor.

		It has 1 constructor, 2 private methods, and 2 public methods:

			1. public Zipcode(int zip)
			2. private void add_num(String bar_phrase)
			3. private void add_code(int num)
			4. public String getZipcode(String bar)
			5. public String getBarcode()

	Explanations:

	1. The constructor Zipcode(int zip)

		This constructor simply takes in the integer zipcode and saves it into the zip_num instance variable, so that zip_num can be used inside class methods.

	2. The method private void add_num(String bar_phrase)

		-This method takes in a barcode phrase and concatenates the corresponding number to 'zipcode' using the table provided in the question. 
		-All 10 possibilities, from 0 through 9, are compared using the switch-case statement.
		-For example, the phrase ':|:|:' is converted to 5 and concatenated to the 'zipcode' instance variable. 
		-The method is private since it doesn't have to be used by the user, but is used by other methods within the class. It has no return type(void) since it directly concatenates the output into the instance variable. 

	3. The method private void add_code(int num)

		-This method takes in a zipcode digit and concatenates the corresponding phrase to 'barcode' using the table provided in the question. 
		-All 10 possibilities, from 0 through 9, are compared using the switch-case statement.
		-For example, the digit '5' is converted to ':|:|:' and concatenated to the 'barcode' instance variable. 
		-The method is private since it doesn't have to be used by the user, but is used by other methods within the class. It has no return type(void) since it directly concatenates the output into the instance variable. 

	4. The method public String getZipcode(String bar)

		This method takes in an entire barcode and converts it to a complete zipcode. 
		-To do this, it takes the ith substring and the jth character within the substring within it. 
		-It then concatenates all the jth characters into a substring and passes it to add_num, which concatenates the zipcode digit corresponding to this substring phrase to the instance variable 'zipcode'. 
		-The substring is reset and the next set of substrings is taken. Note that j starts from 1 and not 0. This is done because the first character of the barcode is expected to be the encasing "|" and so the index we're checking offsets to the right by 1. 
		-The character we're checking will be (i*5)+j. 

		For example consider the barcode '||:|:::|:|:||::::::||:|::|:::|||'. 
		This is how it will go:
			substring = ""
			i=0,j=1: concatenate the char at (i*5)+j = 1, '|' to substring.
			i=0,j=2: concatenate the char at (i*5)+j = 2, ':' to substring.
			i=0,j=3: concatenate the char at (i*5)+j = 3, '|' to substring.
			i=0,j=4: concatenate the char at (i*5)+j = 4, ':' to substring.
			i=0,j=5: concatenate the char at (i*5)+j = 5, ':' to substring.
			Now, the substring holds "|:|::". This is passed to add_num, which concatenates the corresponding digit, "9", to zipcode. Now, substring is reset to "" and it continues to the next substring of 5 characters. 
			i=1,j=1: concatenate the char at (i*5)+j = 6, ':' to substring.
			...and so on...

		I have used the String function [string name].charAt([int]) to return the character at the [int] index of [string name]. However to concatenate, the data type must be String, not char. And so I used the String function concat(Character.toString([char])) to convert the [char] to String so that it can be concatenated. 

	5. The method public String getBarcode()

		This method takes in an entire zipcode and converts it to a complete barcode. I preferred to use the integer version of the zipcode, zip_num as it is easier to process. However in the end we return the String zipcode, the instance variable. 

		-We first do a validation test to check that the number is of 5 or less digits. Only a number greater than 99999, the largest 5-digit number is invalid, and so I've put an if statement that returns the error message string if zip_num is greater than 99999. 
		-I first set 'barcode' to "|" for encasing. 
		-To get each individual character of the zipcode and taking into account padding zeros, I have taken the following approach. 
			-The variable i starts at 10,000 and divides by 10 every time till it is not greater than 0. 
			-This means that zip_num/i will return the digit at the ith place. 
			-Then, I pass zip_num/i into add_code, which concatenates the substring phrase corresponding to the digit to the string barcode, the instance variable. 
			-Finally, we get rid of the digit taking saving the modulus of zip_num with i into zip_num, so that only the rest of the number is now left to be processed. 
			-This goes on till the last digit. 
		Then, the check digit is calculated. 
			-After each digit is passed to add_code, it is also added to sum, which was initialised at sum=0. 
			-Then, sum was subtracted from the next multiple of 10 after sum and saved as the check digit. 
			-The check digit is passed to add_code to concatenate its corresponding barcode phrase to 'barcode'. 
		-After that, the encasing "|" is concatenated.

		For example the zipcode 95014 will go off as follows: 

		sum = 0

		barcode = "|"

		i = 10000
		95014/10000 = 9: concatenate the phrase corresponding to 9 to 'barcode' by using add_code(9)
		sum += 9
		zip_num is now set to 95014 % 10000 = 5014

		i = 1000
		5014/1000 = 5: concatenate the phrase corresponding to 5 to 'barcode' by using add_code(5)
		sum += 5
		zip_num is now set to 5014 % 1000 = 014

		i = 100
		14/100 = 0: concatenate the phrase corresponding to 0 to 'barcode' by using add_code(0)
		sum += 0
		zip_num is now set to 14 % 100 = 14

		i = 10
		14/10 = 1: concatenate the phrase corresponding to 1 to 'barcode' by using add_code(1)
		sum += 1
		zip_num is now set to 14 % 10 = 4

		i = 1
		4/1 = 4: concatenate the phrase corresponding to 4 to 'barcode' by using add_code(4)
		sum += 4
		zip_num is now set to 4 % 1 = 0

		as i = 0, the loop exits.

		the sum is 19.
		the closest multiple of 10 greater than sum = 20
		Thus, the check digit is 20 - 19 = 1
		concatenate the phrase corresponding to 1 to 'barcode' by using add_code(1)

		"|" is concatenated to the barcode

		'barcode' is now "||:|:::|:|:||::::::||:|::|:::|||"









