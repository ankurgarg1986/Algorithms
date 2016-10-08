package dynamicProgramming;

import java.util.Arrays;

public class MinSizeRulesArray {


	private static int  minSizeRecursive(int[] arr, int n, int k) {
	    //int res = 0;
	    int low = 0;
	    int high = n-1;
	    return minSizeUtilRecursive(arr,low,high,k);
	}
	
	private static int minSizeUtilRecursive(int[] arr, int low, int high, int k) {
		int res = 0;
		if(high - low + 1 < 3) 
	    	return high - low + 1;
		int i,j;
		res = 1 + minSizeUtilRecursive(arr,low+1,high,k);//not removing this element
		for(i=low+1;i<=high-1;i++)
		{
			for(j=i+1;j<=high;j++)
			{
				if(arr[i] == arr[low] + k 
				   && arr[j] == arr[i] + k 
				   && minSizeUtilRecursive(arr,low+1,i-1,k)==0 
				   && minSizeUtilRecursive(arr,i+1,j-1,k)==0)
				{
					res = Math.min(res,minSizeUtilRecursive(arr,j+1,high,k));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = {4, 4, 3, 3, 3, 4};
	    int n = arr.length;
	    int k = 0;
	    System.out.println(minSizeRecursive(arr, n, k));
	    System.out.println(minSizeDynamic(arr, n, k));
	}

	private static int minSizeDynamic(int[] arr, int n, int k) {
		int[][] dp = new int[n][n];
		for(int[] dp1 : dp)
		{
			Arrays.fill(dp1, -1);
		}
		return minSizeDynamicUtil(arr,dp,0,n-1,k);
	}

	private static int minSizeDynamicUtil(int[] arr, int[][] dp, int l,int h, int k) {
		if(dp[l][h] != -1)
			return dp[l][h];
		if(h-l +1 < 3 )
			return h-l+1;
		int res  = 1 + minSizeDynamicUtil(arr,dp,l+1,h,k);
		
		return dp[l][h];
		
	}
	
}
