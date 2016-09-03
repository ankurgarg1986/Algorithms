package dynamicProgramming;

public class NumberPathKCoins {

	public static void main(String[] args) {
		int k = 12;
	    int[][] mat = { {1, 2, 3},
	                      {4, 6, 5},
	                      {4, 2, 1}
	                  };
	    System.out.println(pathCountRecursive(mat, k));
	    System.out.println(pathCountDynamic(mat, k));
	 //   return 0;

	}

	/** 
	 * DP to solve number of Paths with k coins
	 * @param mat
	 * @param k
	 * @return
	 */
	private static int pathCountDynamic(int[][] mat, int k) {
		int ans = 0;
		
		return ans;
	}

	private static int pathCountRecursive(int[][] mat, int k) {
		int m = mat.length;
		int n = mat[0].length;
		int ans = pathCountRecursive(mat,m-1,n-1,m-1,n-1,k);
		return ans;
	}

	private static int pathCountRecursive(int[][] mat ,int i, int j,int m,int n, int sum) {
		int res = 0;
		if(i<0 || j< 0 || i>m || j>n) return 0;
		sum = sum -mat[i][j];
		if(sum < 0) return 0;
		if(sum ==0)
		{
			if(i==0 && j==0) return 1;
			return 0;
		}
		res = pathCountRecursive(mat,i-1,j,m,n,sum) + pathCountRecursive(mat,i,j-1,m,n,sum);
		return res;
	}

}
