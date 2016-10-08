package dynamicProgramming;

import java.util.Arrays;

public class NumberPathKTurnsDynamic {

	public static void main(String[] args) {
		int m = 3, n = 3, k = 2;
		System.out.println("Number of paths is " + countTotalPaths(0,0,m - 1, n - 1, k));
	}

	
	private static int countTotalPaths(int x, int y,int m,int n, int k) {
		int[][][][] dp = new int[m+1][n+1][k+1][2];
		for(int[][][] a : dp)
		{
			for(int[][] b : a)
			{
			   for(int[]c : b)
			   {
				   Arrays.fill(c, -1);
			   }
			}	
		}
		int i;
	    for(i=0;i<k;i++)
	    {
	    	dp[m][n][i][0] = 1;
	    	dp[m][n][i][1] = 1;
	    }
	    int ans = countTotalPathsUtil(x+1,y,m,n,k,dp,0) +  countTotalPathsUtil(x,y+1,m,n,k,dp,1);
		return ans;
	}


	private static int countTotalPathsUtil(int i, int j, int m, int n, int k,int[][][][] dp, int d) {
	    int res = 0;
		if(i<0 || j<0 || i>m || j>n ) return 0;
		if (i == m && j == n)
			return 1;
		if (k == 0) {
			// all turns exhausted so if u keep going on same path no more turns
			// are required
			if(d==1)
			{
				//going towards row 
				if(i==m) return 1;
			}
			else 
			{
				if(j==n) return 1;
				
			}
			return 0;
		}
	    if(dp[i][j][k][d] != -1)
	    	return dp[i][j][k][d];//already value set
	    if(d==0)
	    {
	    	//direction along row
	    	res = countTotalPathsUtil(i+1,j,m,n,k,dp,d) + countTotalPathsUtil(i,j+1,m,n,k-1,dp,1-d);
	    }
	    else
	    {
	    	res = countTotalPathsUtil(i,j+1,m,n,k,dp,d) + countTotalPathsUtil(i+1,j,m,n,k-1,dp,1-d);
	    }
		return res;
	}

}
