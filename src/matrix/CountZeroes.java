package matrix;

public class CountZeroes {

	public static void main(String[] args) {
		int[][] mat =
		    {
		        { 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0 },
		        { 0, 0, 1, 1, 1 },
		    };
		  int m = mat.length;
		  int n = mat[0].length;
         System.out.println(countZeroes(mat,m,n));

	}

	private static int countZeroes(int[][] mat, int m, int n) {
		int c = 0;
		int i = m-1;
		int j  = 0;
		while(i>=0)
		{
			while(j<n)
			{
				if(mat[i][j] == 0)
				{
					j++;
					
				}
				else{
					i--;
					c += j;
					break;
				}
			}
			if(j==n)
			{
				//reached end of columns
				c += (i+1)*n;
				return c;
			}
			//i--;
		}
		return c;
	}

}
