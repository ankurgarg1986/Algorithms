package dynamicProgramming;

public class CountWays {

	public static void main(String[] args) {
		
		try { 
			int x = 0; int y = 5 / x;
			}
		catch (Exception e) {
			System.out.println("Exception"); 
			} 
		System.out.println("finished");
		
//		int n = 5;
//	   System.out.println( printCountRec(n));
//	   System.out.println( printDynamic(n));
	}

	private static int printDynamic(int n) {
		int[] dp = new int[n + 1];// dp[i] represents ways to reach i using
									// 1,2,3 steps
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			if (i - 1 >= 0)
				dp[i] += dp[i - 1];
			if (i - 2 >= 0)
				dp[i] += dp[i - 2];
			if (i - 3 >= 0)
				dp[i] += dp[i - 3];
		}
		return dp[n];
	}

	private static int printCountRec(int n) {
		int ans = 0;
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		ans = printCountRec(n - 1) + printCountRec(n - 2)
				+ printCountRec(n - 3);
		return ans;
	}

}
