/**
 * This class tests if the RomanNumeral class works.
 * Name: Shikhar Bakhda
 * UNI: ssb2189
 */
import java.util.* ;

public class RomanNumeralTester {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int dec_num;

        //The code will keep prompting the user to enter a number till a valid number is entered. 
        while(true) {
            System.out.println("Enter the number: ");
            dec_num = scan.nextInt();  //saving the decimal-base number as 'dec_num'
            if (dec_num <= 3999 && dec_num > 0) //checking if the number is >0 and <=3999
                break; //this statement helps break out of the while(true) loop since the entry is valid
            else 
                System.out.println("Number should be positive and less than 4000!");
        }

        //creating a RomanNumeral object called 'roman', passing dec_num into the constructor
        RomanNumeral roman = new RomanNumeral(dec_num); 
         //the getRoman method returns the roman numeral string. This string is printed.
        System.out.println(roman.getRoman());
    }
}