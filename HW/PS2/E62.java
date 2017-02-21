/*
This program has several sub-parts, doing different functions. 
Name: Shikhar Bakhda
*/

import java.util.*;

public class E62 {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    //This section prints the sum of all even numbers between 2 and 100 (inclusive)
        int i;
        int sum=0;
        for(i=2; i<=100;i+=2)
        {
            sum += i;
        }
        System.out.println("The sum of all even numbers between 2 and 100 (inclusive) is " + sum);
    

    //This section prints the sum of the squares of all numbers from 1 to 100 (inclusive)
        sum=0;
        for(i=1;i<=100;i++) 
        {
            sum += i*i;
        }
        System.out.println("The sum of the squares of all numbers from 1 to 100 (inclusive) is " + sum);
    

    //This section prints the first 20 powers of 2
        int num=1;
        for(i=0;i<=20;i++) 
        {
            System.out.println("2^" + i + " = " + num);
            num *= 2;
        }


    //This section prints the sum of all odd numbers between user-input variables 'a' and 'b'    {
        System.out.println("Enter a: ");
        int a = scan.nextInt();
        System.out.println("Enter b: ");
        int b = scan.nextInt();
        sum = 0;
        while(a<=b) 
        {
            if (a%2 == 1)
                sum += a;
            a++;
        }
        System.out.println("The sum of all odd numbers between " + a + " and " + b + " is " + sum);


    //This section prints the sum of all the odd digits of a number entered by the user    {
        System.out.println("Enter number: ");
        num = scan.nextInt();
        sum =0;
        while(num>0) 
        {
            if ((num%10)%2 == 1 )
                sum += num%10;
            num /= 10;
        }
        System.out.println("The sum of all the odd digits of the number entered is " + sum);

    }
}
