import java.util.Scanner;

/**
 * GaussEaster - uses Gauss' algorithm to calculate the date of easter given
 * a specific year.
 *
 * @author Alexander Roth (air2112)
 **/
public class GaussEaster {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the year: ");
        int y = input.nextInt();

        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;

        // We have some domain knowledge that Easter can only fall on either
        // the third or fourth month of the year.
        if (n == 3) {
            System.out.println("Easter Sunday falls on March " + p);
        } else {
            System.out.println("Easter Sunday falls on April " + p);
        }
    }

}
