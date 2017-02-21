import java.util.Scanner;

public class Tester
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Input a zipcode:");
		int zip = input.nextInt();
		Zipcode first = new Zipcode(zip);
		System.out.println("The barcode is: " + first.getBarcode());

		System.out.println("Input a barcode:");
		String bar = input.next();
		Zipcode second = new Zipcode(bar);
		System.out.println("The zipcode is: " + second.getZipcode());

	}
}