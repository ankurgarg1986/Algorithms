package dynamicProgramming;

public class MaxSnakeSequence {

	public static void main(String[] args) {
		int[][] mat =
		    {
		        {9, 6, 5, 2},
		        {8, 7, 6, 5},
		        {7, 3, 1, 6},
		        {1, 1, 1, 7},
		    };
		int m = mat.length;
		int n = mat[0].length;
		int i,j;
		int ans = 0;
		int[][] dp = new int[m][n];
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
				dp[i][j] = -1;
		}
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				//ans = Math.max(ans, findMaxSnakeLength(mat, i,j, m, n));
				ans = Math.max(ans, findMaxSnakeLengthDynamic(mat,i,j,m,n,dp));
			}
		}
		System.out.println(ans);

	}

	private static int findMaxSnakeLengthDynamic(int[][] mat, int x, int y, int m,
			int n, int[][] dp) {
		if(dp[x][y] != -1)
			return dp[x][y];
		int[] dx = {0,1};
		int[] dy = {1,0};
		int x1,y1,i;
		int ans = 1;
		int val = mat[x][y];
		for(i=0;i<2;i++)
		{
			x1 = x + dx[i];
			y1 = y + dy[i];
			if(x1 < 0 || y1<0 || x1>=m || y1>=n)
				//out of bound
				continue;
			if(mat[x1][y1] == val+1 || mat[x1][y1] == val-1)
			{
				ans = Math.max(ans, 1 + findMaxSnakeLength(mat,x1,y1,m,n));
			}
		}
		dp[x][y] = ans;
		return dp[x][y];
	}

	@SuppressWarnings("unused")
	private static int findMaxSnakeLength(int[][] mat, int x, int y, int m,
			int n) {
		int ans = 1;
		int[] dx = {0,1};
		int[] dy = {1,0};
		int x1,y1;
		int i;
		int val = mat[x][y];
		for(i=0;i<2;i++)
		{
			x1 = x + dx[i];
			y1 = y + dy[i];
			if(x1 < 0 || y1<0 || x1>=m || y1>=n)
				//out of bound
				continue;
			if(mat[x1][y1] == val+1 || mat[x1][y1] == val-1)
			{
				ans = Math.max(ans, 1 + findMaxSnakeLength(mat,x1,y1,m,n));
			}
		}
		return ans;
	}
	

}
