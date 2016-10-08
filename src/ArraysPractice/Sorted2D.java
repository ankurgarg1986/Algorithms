package ArraysPractice;

public class Sorted2D {
   private final static int N  = 4;
   private final static int INF = 999;
   
	// This function uses extractMin() to print elements in sorted order
	static void printSorted(int[][] mat)
	{
	  System.out.println("Elements of matrix in sorted order \n");
	   for (int i=0; i<N*N; i++)
	     System.out.print(extractMin(mat) +  " ");
	}
   
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] mat = { {10, 20, 30, 40},
                 {15, 25, 35, 45},
                 {27, 29, 37, 48},
                 {32, 33, 39, 50},
               };
		 printSorted(mat);
	}
	
	static void youngify(int[][] mat, int i, int j)
	{
	    int dValue = (i+1<N) ? mat[i+1][j]:INF;
	    int rValue = (j+1<N) ? mat[i][j+1]:INF;
	    if(dValue == INF && rValue == INF) return;
	    if(dValue < rValue){
	    	mat[i][j] = dValue;
	    	mat[i+1][j] = INF;
	    	youngify(mat,i+1,j);
	    }else{
	    	mat[i][j] = rValue;
	    	mat[i][j+1] = INF;
	    	youngify(mat,i,j+1);
	    }
	    
	}
	 
	// A utility function to extract minimum element from Young tableau
	public static int extractMin(int[][] mat)
	{
	    int ret = mat[0][0];
	    mat[0][0] = INF;
	    youngify(mat, 0, 0);
	    return ret;
	}
	 

	 
	

}
