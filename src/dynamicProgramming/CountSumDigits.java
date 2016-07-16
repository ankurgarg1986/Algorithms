package dynamicProgramming;

public class CountSumDigits {

	public static void main(String[] args) {
		int n = 4, sum = 16;
		System.out.println(finalCount(n, sum,n));
		int[][] dp = new int[n+1][sum+1];
		dp[0][0] = 0;
		int i,j;
		for(i=0;i<=n;i++)
		{
			for(j=0;j<=sum;j++)
				dp[i][j] = 0;
		}
		for(i=1;i<=Math.min(sum, 9);i++)
			dp[1][i] =1;
		System.out.println(finalCountDynamic(n, sum,dp));
	}


	private static int finalCountDynamic(int n, int sum,int[][] dp) {
		if(dp[n][sum] != 0)
			return dp[n][sum];
		int i,j;
		for(i=2;i<=n;i++)
		{
			for(j=0;j<=9;j++)
			{
				 if(sum - j >=0)
				 {
					 dp[i][sum] = dp[i-1][j] + finalCountDynamic(i-1,sum-j,dp);
				 }
			}
		}
		return dp[n][sum];
	}


	private static int finalCount(int n, int sum, int k) {
		int c = 0;
		if ( n == 0)
		{
			if(sum==0) return 1;
			return 0;
		}
		int d = 0;
		if (n == k) {
			// base case
			for (d = 1; d <= 9; d++) {
				if(sum-d >=0) c += finalCount(n - 1, sum - d, k);
				else break;
			}
		} else {
			for (d = 0; d <= 9; d++) {
				if(sum-d >=0 ) c += finalCount(n - 1, sum - d, k);
				else break;
			}
		}
		return c;
	}
}
