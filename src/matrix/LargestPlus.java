package matrix;

public class LargestPlus {

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 } };

		System.out.println(LargestMatrix(mat, mat.length));

	}

	private static int LargestMatrix(int[][] mat, int N) {
		// int ans = 0;
		int[][] left = new int[N][N];
		int[][] right = new int[N][N];
		int[][] top = new int[N][N];
		int[][] bottom = new int[N][N];
		for (int i = 0; i < N; i++) {
			// initialize first row of top
			top[0][i] = mat[0][i];

			// initialize last row of bottom
			bottom[N - 1][i] = mat[N - 1][i];

			// initialize first column of left
			left[i][0] = mat[i][0];

			// initialize last column of right
			right[i][N - 1] = mat[i][N - 1];
		}

		// fill all cells of above four matrix
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				// calculate left matrix (filled left to right)
				if (mat[i][j] == 1)
					left[i][j] = left[i][j - 1] + 1;
				else
					left[i][j] = 0;

				// calculate top matrix
				if (mat[j][i] == 1)
					top[j][i] = top[j - 1][i] + 1;
				else
					top[j][i] = 0;

				// calculate new value of j to calculate
				// value of bottom(i, j) and right(i, j)
				j = N - 1 - j;

				// calculate bottom matrix
				if (mat[j][i] == 1)
					bottom[j][i] = bottom[j + 1][i] + 1;
				else
					bottom[j][i] = 0;

				// calculate right matrix
				if (mat[i][j] == 1)
					right[i][j] = right[i][j + 1] + 1;
				else
					right[i][j] = 0;

				// revert back to old j
				j = N - 1 - j;
			}
		}

		// n stores length of longest + found so far
		int n = 0;

		// compute longest +
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// find minimum of left(i, j), right(i, j),
				// top(i, j), bottom(i, j)
				int len = Math.min(Math.min(top[i][j], bottom[i][j]),
						Math.min(left[i][j], right[i][j]));

				// largest + would be formed by a cell that
				// has maximum value
				if (len > n)
					n = len;
			}
		}

		// 4 directions of length n - 1 and 1 for middle cell

		return 4 * (n - 1) + 1;

		// return ans;
	}

}
