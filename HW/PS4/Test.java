import java.util.Scanner;

public class Test{

    public static void main(String[] args){
        
        int longestRun = 0;
        int a;
        int run;    
        int[] Ary = new int[]{1, 2, 5, 5, 3, 3, 2, 3, 3, 2, 2, 2, 2, 2, 6, 5, 1, 1, 1, 1};
        for(int i=0;i<20;i++)
            {
                a = i;
                run = 0;
                while(Ary[a] == Ary[i]){
                    run++;
                    a++;
                    if(a == 20)
                        break;
                }
                if(run > longestRun)
                    longestRun = run;
            }
        System.out.println(longestRun);

        // int[][] arr = new int[][]{
        //     {'a','b','c'},
        //     {4,5,6},
        // };

        // for(int i=0;i<3;i++)
        //     for(int j=0;j<3;j++)
        //         System.out.println(arr[i][j]);

    }
}
    

