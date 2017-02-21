/**
 * This class converts a decimal integer to a roman numeral. 
 * Name: Shikhar Bakhda
 * UNI: ssb2189
 */
import java.util.*;

public class RomanNumeral {

    public int dec_num; 

    //This constructor saves the user-input value into the integer 'dec_num'
    public RomanNumeral(int dec)
    {
        dec_num = dec; //dec_num contains the integer to be converted.
    }
    
    //This method converts 'dec_num' to the String roman_num, which is returned to the RomanNumeralTester class
    public String getRoman() 
    {
        String roman_num = ""; //roman_num initialised as blank string

        for(int power=1000; power>0; power /= 10) { //This for loop contains digit, which goes from 1000 to 1, through powers of 10
            int digit = dec_num/power; //'place' contains one digit of dec_num, starting from the left and going rightwards
            switch(power) { //comparing the power to 1000, 100, 10, 1, so that the appropriate roman strings can be passed
                case 1000: roman_num = roman_num.concat(add_roman(digit, "M", "", "", "")); //for every case, the output from add_roman is concatenated to roman_num
                    break;
                case 100: roman_num = roman_num.concat(add_roman(digit, "C", "CD", "D", "CM"));
                    break;
                case 10: roman_num = roman_num.concat(add_roman(digit,"X", "XL", "L", "XC"));
                    break;
                case 1: roman_num = roman_num.concat(add_roman(digit, "I", "IV", "V", "IX"));
                    break;
            }
            dec_num -= (digit*power); // This simply adjusts dec_num so that the next digit can be obtained. 
        }
        return(roman_num);
    }

    public String add_roman(int num, String one, String four, String five, String nine){
        
        String roman = ""; //creating an empty string roman

        if (num == 9) {
            num -= 9; 
            roman = roman.concat(nine); //The roman string is concatenated with roman
        }

    
        if (num == 4) {
            num -= 4;
            roman =roman.concat(four);
        }

        if (num >= 5) {
            num -= 5;
            roman =roman.concat(five);
        }

        while (num > 0) { //this loop is executed until that num equals zero, so that I's or X's or C's or M's are sufficiently added 
            num -= 1;
            roman =roman.concat(one);
        }
        
        return(roman);
    }
}
