/*
This program performs a number of operations on a string entered by the user.
Name: Shikhar Bakhda
*/

import java.util.*;

public class E64 {
    public static void main(String[] args) {

        //This section takes a string input from the user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string: \n");
        String str = scan.nextLine();
        int i;


        //This section prints all the letters in upper case in the entered string
        for(i=0;i<str.length();i++)
        {
            if (Character.isUpperCase(str.charAt(i)))
            {
                System.out.println("The letter " + str.charAt(i) + " is in upper case");
            }
        }


        //This section prints every second letter of the entered string
        System.out.println("Each second letter of the string is: \n");
        for(i=1;i<str.length();i+=2)
        {
            System.out.println(str.charAt(i));
        }


        //This replaces every vowel with an underscores
        String under_str="";
        for(i=0;i<str.length();i++)
        {
            under_str = str.replaceAll("[aAeEiIoOuU]", "_");
        }
        System.out.println("The modified string is " + under_str);


        //This section counts the number of vowels
        int num=0;
        for(i=0; i<str.length();i++)
        {
            if(  (str.charAt(i)=='A')||(str.charAt(i)=='a')||(str.charAt(i)=='e')||(str.charAt(i)=='E')||(str.charAt(i)=='i')||(str.charAt(i)=='I')||(str.charAt(i)=='o')||(str.charAt(i)=='O')||(str.charAt(i)=='u')||(str.charAt(i)=='U')  )
            {
                num++;
            }
        }
        System.out.println("There are " + num + " vowels.");


        //This section prints the position of each vowel (The first character has the position 1)
        for(i=0;i<str.length();i++)
        {
            if(  (str.charAt(i)=='A')||(str.charAt(i)=='a')||(str.charAt(i)=='e')||(str.charAt(i)=='E')||(str.charAt(i)=='i')||(str.charAt(i)=='I')||(str.charAt(i)=='o')||(str.charAt(i)=='O')||(str.charAt(i)=='u')||(str.charAt(i)=='U')  )
            {
                System.out.println("There is a vowel at position " + (i+1));
            }
        }
    }
}
