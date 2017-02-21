//**************************************** 
//  This class adds brackets around runs // 
//****************************************

public class PP71{
    public static void main(String[] args){

        boolean inRun = false; // Set a boolean variable inRun to false.
        int[] values = new int[20]; //Initialising an array 'values' of size 20
        Die die = new Die(); //Instantiating an object die of class Die that models a die of 6 sides

        System.out.print("Randomly generated array: "); //Printing the randomly generated array of 20

        //This for loop adds a number generated randomly using the die's getSide method 
        //    and adds it to index i of the array values
        for(int i = 0; i<20; i++){
            values[i] = die.getSide();
            System.out.print(values[i]); //Printing the number at values[i]
        }


        System.out.println(); //Blank line for neat layout
        System.out.print("Array with runs:          "); //Printing the bracketed array  

        // For each valid index i in the array
        for(int i = 0; i<20; i++) {
            if(inRun && i != 0) // If inRun is true, do the following. 
			//Note that we must add another condition, if i != 0 to ensure that 
            //	values[i-1] will not go out of bounds 

            	// If values[i] is different from the preceding value
                if(values[i] != values[i-1]) {
                    System.out.print(")"); // Print ).
                    inRun = false;  // inRun = false.
                }

            if (!inRun && i != 19) // If not inRun
            //Note that we must add another condition, if i != 19 to ensure that 
            //	values[i+1] will not go out of bounds 
                if(values[i] == values[i+1]) { // If values[i] is the same as the following value
                    System.out.print("(");	// Print (.	
                    inRun = true; 	// inRun = true.
                }
            System.out.print(values[i]); // Print values[i].
        }

        if(inRun) // If inRun, 
                System.out.print(")"); // Print ).

        System.out.println(); //Blank line for neat layout
    }
}



















