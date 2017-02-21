import java.util.ArrayList;
import java.util.Arrays;

/**
 * Logest Run - Generates a sequence of random die tosses in an array,
 * and prints the values, marking only the longest run.
 * @author Narcisa Codreanu (ncc2130)
 **/

public class P72 {
    // for testing purposes only - uncomment and use the following array
    // private int[] myArray = {2, 2, 3, 3, 4, 4, 5, 5, 7, 7, 7, 7, 8, 9, 8, 8, 10, 10, 10, 10};
    private int[] myArray;
    private Die myDie;

    public P72(int arrayLength, int dieSides) {
        myArray = new int[arrayLength];
        myDie = new Die(dieSides);
        // populate my array with random die roll values
         for(int i = 0; i < arrayLength; i++) {
            myDie.roll();
            myArray[i] = myDie.getSide();
         }
    }

    public int[] getArray() {
        return myArray;
    }

    // prints the array with parantheses around the longest run
    public void printParanthesised() {
        boolean inRun = false;
        int longestRun = 0, currentRun = 0;
        int currentRunStart = 0, currentRunEnd = 0;
        int longestRunStart = 0, longestRunEnd = 0;
        for(int i = 0; i < myArray.length; i++) {
            if(inRun) {
                if(i != 0 && myArray[i] != myArray[i-1]) {
                    inRun = false;
                    currentRunEnd = i-1;
                    if (currentRun > longestRun) {
                        longestRun = currentRun;
                        longestRunStart = currentRunStart;
                        longestRunEnd = currentRunEnd;
                    }
                    currentRun = 0;
                }
                currentRun++;
            }
            if(!inRun) {
                if(i != myArray.length-1 && myArray[i] == myArray[i+1]) {
                    inRun = true;
                    currentRun = 1;
                    currentRunStart = i;
                }
            }
        }

        for(int i = 0; i < myArray.length; i++) {
            if(i == longestRunStart) {
                System.out.print("( ");
                System.out.print(myArray[i] + " ");
            }
            else {
                if(i == longestRunEnd) {
                    System.out.print(myArray[i] + " ");
                    System.out.print(") ");
                }
                else {
                    System.out.print(myArray[i] + " ");
                }
            }
        } 
    }

    public static void main(String[] args) {
        P72 myObject = new P72(20, 6);
        System.out.println(Arrays.toString(myObject.getArray()));
        myObject.printParanthesised();
    }

}
