package matrix;

public class CountNegetive {

	public static void main(String[] args) {
		int[][] a = { {4,3,2,1},
					  {3,2,3,4},
					  {2,1,7,8} };
		int m = a.length;
		int n = a[0].length;
		System.out.println(countNegetive(a,m,n));
	}

	private static int countNegetive(int[][] a, int m, int n) {
		int ans = 0;
		int i=m-1;
		int j = 0;
		while(j<n)
		{
			while(a[i][j] > 0)
			{
				if(i-1<0)
					return ans;
				i--;
			}
			//else{
				j++;
				ans += i+1;
			//}
		}
		return ans;
	}

}
