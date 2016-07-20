package dynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {

		String s1 = "geek";
		String s2 = "gesek";
		System.out.println(editDistance(s1, s2, 0, 0));
		System.out.println(editDistanceDynamic(s1, s2));

	}

	private static int editDistanceDynamic(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		dp[0][0] = 0;
		int i, j;
		for (i = 0; i <= s1.length(); i++) {
			for (j = 0; j <= s2.length(); j++)
				dp[i][j] = 9999;
		}
		for (i = 0; i <= s1.length(); i++)
			dp[i][0] = i;
		for (j = 0; j <= s2.length(); j++)
			dp[0][j] = j;
		for (i = 1; i <= s1.length(); i++) {
			for (j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	private static int editDistance(String s1, String s2, int i, int j) {
		if (s1.substring(i).equals(s2.substring(j)))
			return 0;
		if (i == s1.length()) {
			return s2.length() - j;
		}
		if (j == s2.length()) {
			return s1.length() - i;
		}
		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
			// same character
			ans = editDistance(s1, s2, i + 1, j + 1);
		} else {
			ans = 1 + Math.min(editDistance(s1, s2, i, j + 1),
					editDistance(s1, s2, i + 1, j));// min of Insert,Remove and
													// Replace
			ans = Math.min(ans, 1 + editDistance(s1, s2, i + 1, j + 1));
		}
		return ans;
	}

}
