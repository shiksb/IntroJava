import java.util.ArrayList;
import java.util.Arrays;

/**
 * Runs - Generates a sequence of random die tosses in an array
 * and prints the values, marking the runs by including them in 
 * parantheses.
 * @author Narcisa Codreanu (ncc2130)
 **/

public class P71 {
    // for testing purposes only - uncomment and use the following array
    // private int[] myArray = {2, 2, 3, 3, 4, 4, 5, 5, 7, 7, 7, 7, 8, 9, 8, 8, 10, 10, 10, 10};
    private int[] myArray;
    private Die myDie;

    public P71(int arrayLength, int dieSides) {
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

    // prints the array with parantheses around the runs
    public void printParanthesised() {
        boolean inRun = false;
        for(int i = 0; i < myArray.length; i++) {
            if(inRun) {
                if(i != 0 && myArray[i] != myArray[i-1]) {
                    System.out.print(") ");
                    inRun = false;
                }
            }
            if(!inRun) {
                if(i != myArray.length-1 && myArray[i] == myArray[i+1]) {
                    System.out.print("( ");
                    inRun = true;
                }
            }
            System.out.print(myArray[i] + " ");
        }
        if(inRun) {
            System.out.print(") ");
        }
    }

    public static void main(String[] args) {
        P71 myObject = new P71(20, 6);
        System.out.println(Arrays.toString(myObject.getArray()));
        myObject.printParanthesised();
    }

}
