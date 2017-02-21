import java.util.ArrayList;

public class stuff{
    public static void main(String[] args){
        
        // int[] array1 = new int[]{1,2,3,4,5};
        // int[] array2 = new int[]{1,2,3};

        // if(array1.length != array2.length){
        //     System.out.println("false");

        // }
        

        // Boolean bool = true;

        // for(int i=0;i<array1.length;i++)
        //     if(array1[i] != array2[i])
        //         bool = false;

        // System.out.println(bool);

        ArrayList<Integer> array1 = new ArrayList<Integer>();

        array1.add(2);
        array1.add(2);
        array1.add(2);
        ArrayList<Integer> array2 = new ArrayList<Integer>(array1);
        System.out.println("" + array2.toString());

    }
} 


// a. Test that two array lists contain the same elements in the same order.
// b. Copy one array list to another.
// c. Fill an array list with zeroes, overwriting all elements in it.
// d. Remove all elements from an array list.


// //This if condition will check if the lengths of the 2 arrays,
// //array1 and array2, is the same. If it is not, the code will return False
// //and the next set of instructions would NOT be executed. 
// if(array1.length != array2.length){
// 	return False;
// }

// //Setting Boolean bool as True. If the loop below doesn't alter bool, it will
// //return the value of bool as True as it is set here. 
// Boolean bool = True;

// //The loop below has an iteration variable 'i' that keeps incrementing by 1 
// //every cycle till it is equal to the length of array1
// for(int i = 0; i < array1.length; i++){
// 	if(array1[i] != array2[i]){ //If ith element of array1 doesn't equal the ith element of array2,
// 		bool = False;//bool is set to False since the test has failed. 
// 	}
// }

// return bool //Returning the value of bool.

// int longestRun = 0;
        // int a;
        // int run;    
        // int[] Ary = new int[]{1, 2, 5, 5, 3, 3, 3, 3, 3, 2, 2, 2, 2, 3, 6, 5, 5, 6, 3, 1};
        // for(int i=0;i<19;i++)
        //     {
        //         a = i;
        //         run = 0;
        //         while(Ary[a] == Ary[i]){
        //             run++;
        //             a++;
        //         }
        //         if(run > longestRun)
        //             longestRun = run;
        //     }
        // System.out.println(longestRun);


    // Set a boolean variable inRun to false.
    // For each valid index i in the array
    // If inRun
    // If values[i] is different from the preceding value
    // Print ).
    // inRun = false.
    // If not inRun
    // If values[i] is the same as the following value
    // Print (.
    // inRun = true.
    // Print values[i].
    // If inRun, print ).

    // Set a boolean variable inRun to false.
    // For each valid index i in the array
    // If inRun
    // If values[i] is different from the preceding value
    // Print ).
    // inRun = false.
    // If not inRun
    // If values[i] is the same as the following value
    // Print (.
    // inRun = true.
    // Print values[i].
    // If inRun, print ).


// for(int i = 0; i<20; i++) {
        //     if(inRun && i != 0)
        //         if(values[i] != values[i-1]) {
        //             System.out.print(")");
        //             inRun = false;
        //         }

        //     if (!inRun && i != 19)
        //         if(values[i] == values[i+1]) {
        //             System.out.print("(");
        //             inRun = true;
        //         }
        //     System.out.print(values[i]);
        // }
        // if(inRun)
        //         System.out.print(")");
