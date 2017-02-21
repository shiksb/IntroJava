/**
 * This class simulates and prints the path of a drunkard. 
 * Name: Shikhar Bakhda
 * UNI: ssb2189
 */

import java.util.*;


public class Drunkard {

    public int ave; //saves the avenue 
    public int str; //saves the street
    public int ave_init; //saves the initial avenue 
    public int str_init; //saves the initial street

    //This constructor saves the starting 'x' position into ave and ave_init
    //This constructor saves the starting 'y' position into str and str_init
    public Drunkard(int x, int y){
        ave = x;
        ave_init = x;
        str = y;
        str_init = y;
    }


    //This method advances the drunkard to an adjacent intersection in a random direction
    public void step() {
    	int dir = (int) (Math.random()*4)+1; //'dir' contains a direction between 1 to 4 inclusive, generated randomly by Math.random()
        switch (dir){   //this switch-case statement compares the value of dir to the numbers 1 to 4. Depending on them it increments or decrements the street or avenue 
            case 1: str--;
                break;
            case 2: ave--;
                break;
            case 3: str++;
                break;
            case 4: ave++;
                break;
            }
    }

    //This method advances the drunkard 'steps' number of steps, each randomly generated
    public void fastForward(int steps) {
        for(int i = 0; i < steps; i++)
            step(); //the step function is executed steps number of times
    }

    //This method returns the location of the drunkard as a string. 
    public String getLocation(){
        String loc = "";
        loc = loc.concat("avenue(x): ").concat(Integer.toString(ave)).concat("; street(y): ").concat(Integer.toString(str));
        return(loc);
    }

    //This method returns the distance, in blocks, since the drunkard's initial position.
    public int howFar() {
        int dist = (Math.abs(ave - ave_init)) + (Math.abs(str - str_init));
        return(dist);
    }
}
