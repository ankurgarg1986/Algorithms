package dynamicProgramming;

public class LCS {

	public static void main(String[] args) {

		String x = "AGGTAB";
		String y = "GXTXAYB";
		int m = x.length();
		int n = y.length();
		System.out.println(lcsRecursive(x, y, 0,0,m, n));
		System.out.println(lcsDynamic(x, y,m, n));
		//System.out.println(lcsDynamicSpaceOptimized(x, y,m, n));

	}


	private static int lcsDynamic(String x, String y, int m,int n) {
		int[][] dp = new int[m+1][n+1];//dp[i][j] gives lcsPath from i to j
		int i,j;
		dp[0][0] = 0;
		for(i=0;i<m;i++)
		{	
			for(j=0;j<n;j++)
				dp[i][j] = 0;
		}
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}

	private static int lcsRecursive(String x, String y,int i,int j, int m, int n) {
		int ans  = 0;
		if(i >= m || j>= n ) return 0;
		if(x.charAt(i) == y.charAt(j))
		{
			ans = 1 + lcsRecursive(x,y,i+1,j+1,m,n);
		}
		else
		{
			ans = Math.max(lcsRecursive(x,y,i+1,j,m,n) , lcsRecursive(x,y,i,j+1,m,n));
		}
		return ans;
	}

}
