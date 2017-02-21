public class Tp {
	private int[][] integers = new int[3][3];

	public int[][] squares(int[][] xyz){

		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				integers[i][j] = xyz[i][j]*xyz[i][j];

		return(integers);
	}
}