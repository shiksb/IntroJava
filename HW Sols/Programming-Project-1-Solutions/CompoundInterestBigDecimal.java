import java.util.Scanner;
import java.math.BigDecimal;

/**
 * OPTIONAL:
 * Optimal and more advanced solution of the Compound Interest problem.
 * As some of you might have noticed, there seems to be an issue when using 
 * floating-point numbers to represent money. Why were you getting incorrect 
 * results when rounding? Does your computer not know how to calculate?
 * This article does a good job of explaining what's going on: 
 * http://www.javaranch.com/journal/2003/07/MoneyInJava.html
 * A way to solve this issue is to use the BigDecimal class, which does not
 * pose issues because it stores the numbers in arrays.
 * 
 * @author Narcisa Codreanu (ncc2130)
 **/
public class CompoundInterestBigDecimal {

    public static void main(String[] args) {

        // Create a scanner and ask for input
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the initial balance: ");
        BigDecimal initialBalance = new BigDecimal(input.next());

        System.out.print("Please input the annual interest rate: ");
        BigDecimal interestRate = new BigDecimal(input.next());

        // Determine the monthly balance
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal twelve = new BigDecimal("12");
        BigDecimal one = new BigDecimal("1");
        
        // month balance = previous balance * (1 + (interest rate/100)/months)
        BigDecimal firstMonth = initialBalance.multiply(interestRate.
            divide(hundred).divide(twelve).add(one));
        BigDecimal secondMonth = firstMonth.multiply(interestRate.
            divide(hundred).divide(twelve).add(one));
        BigDecimal thirdMonth = secondMonth.multiply(interestRate.
            divide(hundred).divide(twelve).add(one));

        // Output to the user
        System.out.println("After first month:\t" + firstMonth.
            setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("After second month:\t" + secondMonth.
            setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("After third month:\t" + thirdMonth.
            setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
