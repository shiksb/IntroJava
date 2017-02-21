//*********************************
//
// Zipcode class   
//
// This is a template for your Zipcode class
// You may add methods and instance variables to this
// class but your code must work with the provided test class ZipTest.java
//
//*********************************

//Zipcode class
//This class helps the user to convert zipcodes to their barcodes, and vice versa
public class Zipcode{

    private String zipcode; // Contains the zipcode in String format
    private String barcode; // Contains the barcode in String format
    private int zip_num;    // Contains the zipcode in int format



    // This constructor takes the integer zipcode as a parameter and saves it in the
    // instance variable 'zip_num' 
    public Zipcode(int zip){
    // add your own code here to
    // to complete the constructor
        zip_num = zip;
    }



// you will need to add more your own methods here




    //This method takes a bar_phrase, such as ':|:|:', as a parameter
    //It returns the integer that corresponds to that phrase. For ex: ':|:|:' returns 5. 
    private void add_num(String bar_phrase){ 
        //This switch case statement compares bar_phrase to all possibilities, from 0 to 9
        //It then concatenates the corresponding value to the instance variable string 'zipcode'
    	switch(bar_phrase){
    			case "||:::": zipcode += 0;
    				break;
    			case ":::||": zipcode += 1;
    				break;
    			case "::|:|": zipcode += 2;
    				break;
    			case "::||:": zipcode += 3;
    				break;
    			case ":|::|": zipcode += 4;
    				break;
    			case ":|:|:": zipcode += 5;
    				break;
    			case ":||::": zipcode += 6;
    				break;
    			case "|:::|": zipcode += 7;
    				break;
    			case "|::|:": zipcode += 8;
    				break;
    			case "|:|::": zipcode += 9;
    				break;
    		}
    }




    //This method takes an integer 'num' as a parameter
    //It concatenates the corresponding barcode phrase to the instance variable 'barcode' 
    private void add_code(int num){

        //This switch case statement compares num to all possibilities, from 0 to 9
        //It then concatenates the corresponding barcode phrase of the integer to 'barcode'        
    	switch(num){
    			case 0: barcode = barcode.concat("||:::");
    				break;
    			case 1: barcode = barcode.concat(":::||");
    				break;
    			case 2: barcode = barcode.concat("::|:|");
    				break;
    			case 3: barcode = barcode.concat("::||:");
    				break;
    			case 4: barcode = barcode.concat(":|::|");
    				break;
    			case 5: barcode = barcode.concat(":|:|:");
    				break;
    			case 6: barcode = barcode.concat(":||::");
    				break;
    			case 7: barcode = barcode.concat("|:::|");
    				break;
    			case 8: barcode = barcode.concat("|::|:");
    				break;
    			case 9: barcode = barcode.concat("|:|::");
    				break;
    		}
    }




    //This method converts a barcode to a string zipcode
    //It takes the barcode as a String 'bar' and returns the zipcode in the String format
    public String getZipcode(String bar){
    	int i,j; // initialising 2 variables for loop iteration, i and j
    	zipcode = ""; // initialising the zipcode instance variable as a blank string ""
        //This for loop refers to the 5 five-character-substrings of the barcode, 
        // such as ':|:|:'
    	for(i=0;i<5;i++)
    	{  
            //The five-character-subtring 'sub_barcode' is reset to ""  
    		String sub_barcode = "";
            //This for loop refers to the starting index of the character within the barcode substring
    		for(j=1; j<6; j++)
                //sub_barcode concatenates the next character of the substring
                //i refers to the substring and j refers to the character within the substring
                //By starting j at 1 and not 0, we're able to skip the character at index 0, which is 
                // the encasing '|'. Thus the first character of the first substring is (0*5)+1 = 1. 
    			sub_barcode = sub_barcode.concat(Character.toString(bar.charAt((i*5)+j)));
            //zipcode concatenates the number corresponding to the barcode substring using 
            // the add_num method
    		  add_num(sub_barcode);
		}

    	return zipcode; //the string version of the zipcode is returned
    }




    //This method converts the zipcode to the barcode
    //It returns the String 'barcode' and uses the instance variable 'zip_num', which is 
    // the integer version of the zipcode
    public String getBarcode(){
	//leave this method as is

        //If the zipcode is a 6-digit number then an error message is returned.
        //As our return type is String, we can directly return the error message string
    	if(zip_num > 99999)
    		return "Invalid Input: Enter a 5 digit string"; //returning the error message

    	int sum = 0; //'sum' is used later to calculate the check digit. It starts at 0
    	int i; // 'i' is used for loop iterations
        int check; //'check' contains the check digit
        //we first initialise the instance variable barcode as "|" as the barcode is encased in "|"s
    	barcode = "|";  

        //This is how this loop works:
        //1. It passes the digit at the ith place into add_code, which concatenates the corresponding
        //substring phrase to the instance variable barcode.
        //2. It then adds the digit to 'sum'
        //3. It then gets rid of that digit by taking the modulus of i, so that the remaining number 
        //is now saved in zip_num

        //This happens 5 times, and i is divided by 10 every iteration of the loop
        //What's best about this approach is it inherently takes care of zero-padding
        //If there were only 3 digits, the 10,000th and 1000th place digit would be read as zero
    	for(i=10000; i>0; i/=10) 
    	{
    		add_code(zip_num/i);
    		sum += (zip_num/i);
    		zip_num %= i;
    	}

        //This for loop is just an abridged way to get the next multiple of 10 from sum
        //You keep adding 10 to i until i is no longer smaller than sum
    	for(i=0; i<sum; i+=10);

        //Then, the integer 'check' gets the difference between sum and the next multiple of 10
    	check = i - sum;
        //'check' is passed to add_code. This method concatenates the substring phrase for 'check'
        // to the instance variable barcode
    	add_code(check);
    	barcode = barcode.concat("|"); //This simply concatenates "|" to end the encasing of barcode

        return barcode; //The string barcode is returned
    }

}


