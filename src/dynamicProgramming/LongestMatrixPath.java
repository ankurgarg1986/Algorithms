package dynamicProgramming;

public class LongestMatrixPath {

	public static void main(String[] args) {
		int[][]  mat = {{1, 2, 9},
                {6, 3, 8},
                {5, 4, 7}};
		int m  = mat.length;
		int n = mat[0].length;
		int ans = 0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				ans = Math.max(ans,longestPathRecursive(mat,i,j,m,n,mat[i][j],0));
			}
		}
       System.out.println(ans);
       int res = 1;
       int[][] dp = new int[m][n];
       for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
			   dp[i][j] = 0;
			}
		}
       for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				res = Math.max(res,longestPathDynamic(mat,i,j,m,n,mat[i][j],dp));
			}
		}
       System.out.println(res);

	}

	private static int longestPathDynamic(int[][] mat, int i, int j, int m,	int n,int val,int[][]dp) {
		if(!checkBoundary(i,j,m,n)) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		dp[i][j] = 1;
        if(checkBoundary(i+1,j,m,n) && mat[i+1][j] == val+1 )
        {
        	dp[i][j] +=  longestPathDynamic(mat,i+1,j,m,n,val+1,dp);
        }
        if(checkBoundary(i-1,j,m,n) && mat[i-1][j] == val+1 )
        {
        	dp[i][j] +=  longestPathDynamic(mat,i-1,j,m,n,val+1,dp);
        }
        if(checkBoundary(i,j+1,m,n) && mat[i][j+1] == val+1 )
        {
        	dp[i][j] +=  longestPathDynamic(mat,i,j+1,m,n,val+1,dp);
        }
        if(checkBoundary(i,j-1,m,n) && mat[i][j-1] == val+1 )
        {
        	dp[i][j] +=  longestPathDynamic(mat,i,j-1,m,n,val+1,dp);
        }
		return dp[i][j];
	}

	private static int longestPathRecursive(int[][] mat,int i,int j, int m, int n, int val,int ans) {
		if(!checkBoundary(i,j,m,n)) return 0;
		int ans1 = 1;
		if(mat[i][j] == val)
		{
			ans++;
		    ans1 = Math.max(ans1,longestPathRecursive(mat,i+1,j,m,n,val+1,ans));
		    ans1 = Math.max(ans1, longestPathRecursive(mat,i-1,j,m,n,val+1,ans));
			ans1 = Math.max(ans1,longestPathRecursive(mat,i,j+1,m,n,val+1,ans));
			ans1 = Math.max(ans1,longestPathRecursive(mat,i,j-1,m,n,val+1,ans));
		}
		return Math.max(ans1,ans);
	}

	private static boolean checkBoundary(int i, int j, int m, int n) {
		if(i<0 || j<0 || i>=m || j>=n) return false;
		return true;
	}

}
