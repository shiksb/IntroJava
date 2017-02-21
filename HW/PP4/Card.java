//------------------------------------------------------//
//Author: Shikhar Bakhda
//UNI: ssb2189
//Card.java
//This program defines a class Card that contains 
//2 instance variables, value and shape, which are defined
//when a card is instantiated using the constructor.
//It also contains a method printCard that prints a Card
//object using actual shapes.
//------------------------------------------------------//
public class Card{

	//Defining the instance variables value and shape
	public int value; //Stores the value of the card, for example 1, 10, 13
	public int shape; //Stores the shape of the card, for example 1, 2, 3, 4

	//This constructor initialises the instance variables based on user inputs
	public Card(int val, int shp){
		value = val; //instance variable 'value' is defined
		shape = shp; //instance variable 'shape' is defined
	}

	// This prints the Card's face value (such as A, J, Q, K) and suite using
	//		Unicode characters
	public String printCard() {
		String face; // contains the card's face value

		//Defining the card's face value (A,J,Q,K,or number)
		if(value == 1){
			face = "A"; //'A' for 1, or ace
		}
		else if(value == 11){
			face = "J"; //'J' for 11, or jack
		}
		else if(value == 12){
			face = "Q"; //'Q' for 12, or queen
		}
		else if(value == 13){
			face = "K"; //'K' for 13, or king
		}
		else{
			face = Integer.toString(value); //convert integer to string for
												//the remaining values
		}

		//Defining the shape's face value (spade,diamond,club,heart symbols)
		if(shape == 1){
			return("\u2660" + face + " ");//Spade unicode
		}
		else if(shape == 2){
			return("\u2666" + face + " ");//Diamond unicode
		}
		else if(shape == 3){
			return("\u2663" + face + " ");//Club unicode
		}
		else{
			return("\u2665" + face + " ");//Heart unicode
		}
	}
}