package dynamicProgramming;

public class LongestConsecutivePath {

	public static void main(String[] args) {
		char[][] mat = { { 'a', 'c', 'd' }, { 'h', 'x', 'e' },
				{ 'i', 'g', 'f' } };
		System.out.println(getLen(mat, 'a'));
		System.out.println(getLenDynamic(mat, 'a'));
		System.out.println(getLen(mat, 'e'));
		System.out.println(getLenDynamic(mat, 'e'));
		System.out.println(getLen(mat, 'b'));
		System.out.println(getLenDynamic(mat, 'b'));
		System.out.println(getLen(mat, 'f'));
		System.out.println(getLenDynamic(mat, 'f'));
		System.out.println(getLenDynamic(mat, 'd'));
	}

	private static int getLenDynamic(char[][] mat, char ch) {
		int ans = 0;
		int m = mat.length;
		int n = mat[0].length;
		int i, j;
		int[][] dp = new int[m][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				dp[i][j] = -1;
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (mat[i][j] == ch) {
					ans = Math.max(ans,
							1 + getLenDynamicUtil(mat, i, j, m, n, ch, dp));
				}
			}
		}
		return ans;
	}

	private static int getLenDynamicUtil(char[][] mat, int x, int y, int m,
			int n, char ch, int[][] dp) {
		if (x < 0 || y < 0 || x >= m || y >= n)
			return 0;
		if (dp[x][y] != -1)
			return dp[x][y];
		int[] dx = { -1, -1, -1, 0,  0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1,  1, -1, 0, 1 };
		int i, j;
		int ans = 0;
		for (i = 0; i < 8; i++) {
			// for(j=0;j<8;j++)
			// {
			int x1 = x + dx[i];
			int y1 = y + dy[i];
			if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n)
				continue;
			if (mat[x1][y1] - ch == 1) {
				ans = Math.max(ans,
						1 + getLenDynamicUtil(mat, x1, y1, m, n, mat[x1][y1], dp));
			}

			// }
		}
		dp[x][y] = ans;
		return dp[x][y];
	}

	private static int getLen(char[][] mat, char ch) {

		int i, j;
		int ans = 0;
		int m = mat.length;
		int n = mat[0].length;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (mat[i][j] == ch) {
					// found a character
					ans = Math.max(ans, getLenHelper(mat, ch, i, j, m, n));
				}
			}
		}
		return ans;
	}

	private static int getLenHelper(char[][] mat, char ch, int x1, int y1,
			int m, int n) {
		int[] dx = { -1, -1, -1, 0,  0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1,  1, -1, 0, 1 };
		int ans = 1;
		int i;
		for (i = 0; i < 8; i++) {
			int x = x1 + dx[i];
			int y = y1 + dy[i];
			if (x >= 0 && y >= 0 && x < m && y < n) {
				if (mat[x][y] - ch == 1) {
					ans = Math.max(ans,
							1 + getLenHelper(mat, mat[x][y], x, y, m, n));
				}
			}
		}
		return ans;
	}

}
