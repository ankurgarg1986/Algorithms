package graphs;

/**
 * Sort of Boggle . Here we have to find a word if it
 * exists in a 2d matrix such that u can go to adjacent
 * 8 cells to find the next letter for the word . Also
 * no cell should be repeated twice . If such a word 
 * exists return true else false. Used DFS using recursion to solve this. 
 * @author agarg
 *
 */
public class Boggle {

	public static void main(String[] args) {
		String boggle = "GEEKS";
		// , "FOR", "QUIZ", "GO" };
		char[][] bo = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' }, { 'P', 'Q', 'R' } };

		System.out.print("Following words of dictionary are present " + findWords(boggle, bo));
	}

	private static boolean findWords(String boggle, char[][] bo) {
		int m = bo.length;
		int n = bo[0].length;
		int i, j;
		boolean[][] visited = new boolean[m][n];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++)
				visited[i][j] = false;
		}
		// for (i = 0; i < boggle.length; i++) {
		// String s = boggle[i];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (!visited[i][j]) {
					if (bo[i][j] == boggle.charAt(0)) {
						visited[i][j] = true;
						String str = boggle.substring(1);
						return findWordsUtil(str, i, j, bo, m, n, visited);
					}
				}
			}
		}
		// }
		return false;// false
	}

	private static boolean findWordsUtil(String str, int x, int y, char[][] bo,
			int m, int n, boolean[][] visited) {

		int i,j;
		if (str.length() == 0)
			return true;
		int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int[] dy = { 0,-1, 1, -1, 0, 1, -1, 1 };
		int k;
		for (k = 0; k < 8; k++) {
			i = x + dx[k];
			j = y + dy[k];
			if (isSafe(i, j, m, n) && !visited[i][j]) {
				if (str.charAt(0) == bo[i][j]) {
					// Found a match
					visited[i][j] = true;
					String str1 = str.substring(1);// Can We Optimize
					if (findWordsUtil(str1, i, j, bo, m, n, visited)) {
						return true;
					}
				}

			}
		}
		return false;
	}

	private static boolean isSafe(int i, int j, int m, int n) {
		// i is row and j is column
		return (i >= 0 && i < m && j >= 0 && j < n);
	}

}
