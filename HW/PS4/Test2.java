import java.util.Scanner;

public class Test2{

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

    public static void main(String[] args){

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

        boolean inRun = false; 
        int[] values = new int[20];
        int die;

        for(int i = 0; i<20; i++){
            die = (int) (Math.random()*6)+1;
            values[i] = die;
            System.out.print(die);
        }

        System.out.println("");

        for(int i = 0; i<20; i++) {
            if(inRun && i != 0)
                if(values[i] != values[i-1]) {
                    System.out.print(")");
                    inRun = false;
                }

            if (!inRun && i != 19)
                if(values[i] == values[i+1]) {
                    System.out.print("(");
                    inRun = true;
                }
            System.out.print(values[i]);
        }
        if(inRun)
                System.out.print(")");

        System.out.println("");
    }
}
    











