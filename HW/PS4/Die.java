//Both P7.1 and P7.2 use this class
//**************************************** 
//  This class models a n-sided die // 
//****************************************


//NOTE: I have copied the Prof's Die class, but removed the constructor with one parameter
// I have also directly initialised the variable n at 6 as we're dealing with a 6 side die

public class Die {         
	private int n;     
	private int side;

    public Die(){ 
    	n = 6;            
    }

    public void roll() {
	side = (int) (Math.random() * n + 1);
    }

    public int getSide() { 
    	roll();
    	return side;     
    }
} //end class