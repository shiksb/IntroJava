import java.util.Scanner;

/**
 * CompoundInterest - Calculates the first three months deposit balance 
 * for monthly compunded interest. 
 *
 * @author Narcisa Codreanu (ncc2130)
 **/
public class CompoundInterest {

    public static void main(String[] args) {

        // Create a scanner and ask for input
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the initial balance: ");
        double balance = input.nextDouble();

        System.out.print("Please input the annual interest rate: ");
        double interestRate = input.nextDouble();

        double firstMonth = 0.0;
        double secondMonth = 0.0;
        double thirdMonth = 0.0;

        // Determine the monthly balance
        for (int month = 0; month < 3; month++) {
            double interest = balance * interestRate / 100 / 12;
            balance += interest;

            switch (month) {
                case 0: firstMonth = balance;
                case 1: secondMonth = balance;
                case 2: thirdMonth = balance;
            }
        }

        // Output to the user
        System.out.printf("After first month:\t %.2f \n", firstMonth);
        System.out.printf("After second month:\t %.2f \n", secondMonth);
        System.out.printf("After third month:\t %.2f \n", thirdMonth);
    }

}
