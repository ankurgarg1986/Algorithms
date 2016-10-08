package dynamicProgramming;

public class MaxSumRectangle {

	public static void main(String[] args) {
		int ans = findMaxSubMatrix(new int[][] { { 1, 2, -1, -4, -20 },
				{ -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });
		System.out.println(ans);

	}

	private static int findMaxSubMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int i, j;
		int t, b;
		int ans = -9999;
		int[] res = { -9999, 0, -1 };
		for (int l = 0; l < m; l++) {
			int[] tmp = new int[m];// row wise sum
			for (int r = l; r < n; r++) {
				for (i = 0; i < m; i++)
					tmp[i] += a[i][r];
				res = kadane(tmp, res);
				int sum = res[0];
				if (ans < sum) {
					ans = sum;
					t = res[1];
					b = res[2];
				}
			}

		}
		return ans;
	}

	private static int[] kadane(int[] tmp, int[] res) {

		int sum = tmp[0];
		//int curr_sum = tmp[0];
		res[1] = 0;
		res[2] = 0;
		for (int i = 1; i < tmp.length; i++) {
			if (tmp[i] > 0 && sum >0) {
				sum = tmp[i] + sum;
				res[1] = i;
			} 
			else if (sum <0){
				if(tmp[i] > sum)
				{
					sum = tmp[i];
					res[1] = i;
					res[2] = i;
				}
			}
		}
		res[0] = sum;
		return res;
	}

}
