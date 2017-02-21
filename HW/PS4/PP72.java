//****************************************************
//  This class adds brackets around the longest run // 
//****************************************************


public class PP72{
    public static void main(String[] args){

        int longestRun = 0; // This integer saves the length of the longest run so far
        int currentRunIndex;  //This integer saves the index of the run being processed
        int currentRun;    //This integer saves the length of the current run 
        int startingIndex = 0;  //This integer saves the starting index of the longest run 

        int[] values = new int[20]; //This integer array contians the 20 random values
        Die die = new Die(); //Instantiating an object die of class Die that models a die of 6 sides

        System.out.print("Randomly generated array: "); //Printing the randomly generated array of 20

        //This for loop adds a number generated randomly using the die's getSide method 
            //    and adds it to index i of the array values
        for(int i = 0; i<20; i++){
            values[i] = die.getSide();
            System.out.print(values[i]); //Printing the number at values[i]
        }


        System.out.println(); //Blank line for neat layout

        for(int i=0;i<20;i++) {
            currentRunIndex = i; //Setting currentRunIndex to the current index
            currentRun = 0; //The length of the current run is initialised as 0

            while(values[currentRunIndex] == values[i]){
                currentRunIndex++;  // We keep incrementing the index of the run while the 
                                //  element at that index equals the first element
                currentRun++; //We also increment the length of the current run by 1 
                            //  till the element doesn't match the first elemtent
                if(currentRunIndex == 20) //This breaks out of the loop if the index crosses 20, 
                                    //to prevent the array index from overflowing and giving errors
                    break;
            }

            if(currentRun > longestRun){ //If the length of the current run is greater than the longest run,
                longestRun = currentRun; // The longestRun is set to the current run length
                startingIndex = i; //and the starting index of this longest run is recorded
            }
        }

        System.out.print("Array with longest run:   ");  //Printing the bracketed array  

        //This for loop goes through every valid index number, from 0 to 19 inclusive
        for(int i=0; i<20;i++){
            if(i==startingIndex) //If the index equals the starting index of the longest run, '(' is added
                System.out.print("(");

            else if(i==startingIndex+longestRun) //If the index equals the ending index of the longest run, 
                                //'(' is added. The ending index will be the starting index + length of run
                System.out.print(")");

            System.out.print(values[i]); //Printing the value at the index i
        }

        System.out.println(); //Blank line for neat layout
    }
}
    











