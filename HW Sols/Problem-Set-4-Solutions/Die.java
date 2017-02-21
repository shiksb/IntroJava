//****************************************
//  This class models a n-sided die
//
//
//****************************************


public class Die {
    
    private int n;
    private int side;

    public Die(int shape){
	n=shape;
	roll();
    }
      
    public void roll() {
	side = (int) (Math.random() * n + 1);
    }

    public int getSide() {
	return side;
    }


} //end class
