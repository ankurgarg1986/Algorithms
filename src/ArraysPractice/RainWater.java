package ArraysPractice;

public class RainWater {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(findWater(arr, arr.length));

	}

	private static int findWater(int[] a, int n) {
		int ans = 0;
		int minm = 999;
		int maxm = -999;
		int i, j;
		for (i = 0; i < n; i++) {
			if (a[i] != 0) {
				if (minm > a[i])
					minm = i;
				if (a[i] >= maxm)
					maxm = i;
			}
		}
		i = 0;
		j = 0;
		if(maxm > minm )
		{
			ans += calculate(minm,maxm,a);
		}
		else
		{
			
		}
		return ans;
	}

	private static int calculate(int minm, int maxm, int[] a) {
		int i;
		int c = 0;
		for(i=maxm;i<=minm;i++)
		{
			 c += a[i];
		}
		return c;
	}

}
