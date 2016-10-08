package dynamicProgramming;

public class LongestSubstring {

	public static void main(String[] args) {
		String str = "1538023";
		System.out.println("Length of the substring is "
				+ findLength(str, str.length()));
		System.out.println("Length of the substring is "
				+ findLengthCumulative(str, str.length()));
		System.out.println("Length of the substring is "
				+ findLengthCumulativeConstant(str, str.length()));

	}

	private static int findLengthCumulativeConstant(String str, int n) {
		int ans = 0;
		if(n==0 || n==1) return 0;
		int l,r;
		int i,len;
		for(len=2;len<=n;len+=2)
		{
			for(i=0;i<;i++)
			{
				
			}
		}
		return ans;
	}

	/**
	 * Solution in O(n^2) time and O(n) space
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	private static int findLengthCumulative(String str, int n) {
		int ans = 0;
		int[] sum = new int[n + 1];
		sum[0] = 0;
		int i;
		for (i = 1; i <= n; i++) {
			sum[i] = str.charAt(i - 1) - '0' + sum[i - 1];
		}
		int j, k;
		for (int len = 2; len <= n; len += 2) {
			for (i = 0; i <= n - len; i++) {
				j = i + len;
				k = len / 2;
				if (sum[i + k] - sum[i] == sum[j] - sum[i + k]) {
					ans = Math.max(len, ans);
				}
			}
		}

		return ans;
	}

	/**
	 * Dynamic Programming solution for O(n^2) space and time
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	private static int findLength(String s, int n) {

		int[][] dp = new int[n][n];
		int ans = 0;
		int i;
		for (i = 0; i < n; i++)
			dp[i][i] = s.charAt(i) - '0';
		// int j, k;

		return ans;
	}

}
