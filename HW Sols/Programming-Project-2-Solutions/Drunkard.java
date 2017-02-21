//***********************
// Drunkard.java
// Written by Narcisa Codreanu & Ethan Adams
// COMS W1004 Fall 2016
//***********************

//** Objects of this class compute the Drunkard's (Random) Walk.*/

public class Drunkard {
	
	private int currentAve;
	private int currentStreet;
	private int initialAve;
	private int initialStreet;
	
	
	// This constructor accepts two integers as input
	// and initializes instance variables: currentAve, currentStreet,
	// initialAve, initialStreet and choice.
	public Drunkard(int x, int y)
	{
		currentAve = x;
		currentStreet = y;
		initialAve = x;
		initialStreet = y;
		
	}
	
	// This method moves the drunkard to the next randomly chosen position.
	// NOTE: Since he is in an intersection, he has 4 possible choices and so
	// the result of the randomization is multiplied by 4 (variable choice 
	// can be 0, 1, 2 or 3).
	public void step()
	{
		int choice = (int) (Math.random() * 4);

		switch (choice)
		{
			case 0: currentAve += 1;
					break;
			case 1: currentAve -= 1;
					break;
			case 2: currentStreet += 1;
					break;
			case 3: currentStreet -= 1;
					break;
			default: System.out.println("Something went wrong...");
					break;
		}
	}
	
	// This method makes the drunkard move randomly a given number 
	// of intersections, invoking method step().
	public void fastForward (int steps)
	{
		while (steps > 0)
		{
			step();
			steps--;
		}
	}
	
	// This method indicates the current location of the drunkard.
	public String getLocation()
	{
		return currentAve + " avenue and "
				+ currentStreet + " street.";
	}
	
	// This method returns the drunkard's distance in blocks 
	// from where he started.
	public int howFar()
	{
		return Math.abs(initialAve - currentAve) + 
		Math.abs(initialStreet - currentStreet);
	}

}// End of class.