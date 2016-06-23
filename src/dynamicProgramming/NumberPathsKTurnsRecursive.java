package dynamicProgramming;

public class NumberPathsKTurnsRecursive {
	public static void main(String[] args) {
		int m = 3, n = 3, k = 2;
		System.out.println("Number of paths is " + countPaths(m - 1, n - 1, k));

	}

	private static int countPathsHelper(int i, int j, int m, int n, int k) {

		int ans = countPathsHelperDirection(i, j+1 , m, n, k, 0) + countPathsHelperDirection(i+1 , j, m, n, k, 1);
		return ans;
	}

	private static int countPathsHelperDirection(int i, int j, int m, int n,int k, int d) {

		if (i > m || j > n || i < 0 || j < 0)
			return 0;// out of bounds
		if (i == m && j == n)
			return 1;
		if (k == 0) {
			// all turns exhausted so if u keep going on same path no more turns
			// are required
			if(d==0)
			{
				//going towards row 
				if(i==m) return 1;
			}
			else 
			{
				if(j==n) return 1;
				
			}
			return 0;
		}
		int res = 0;
		if (d == 0)
			res = countPathsHelperDirection(i, j + 1, m, n, k, d) + countPathsHelperDirection(i + 1, j, m, n, k - 1, 1 - d);
		else
			res = countPathsHelperDirection(i + 1, j, m, n, k, d) + countPathsHelperDirection(i, j + 1, m, n, k - 1, 1 - d);
		return res;
	}

	private static int countPaths(int m, int n, int k) {
		int ans = countPathsHelper(0, 0, m, n, k);
		return ans;
	}

}
