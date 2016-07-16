package codeChefSnackDown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BetterMaximulSum {

	public static long maximumSum(long[] a)
	{
		int n = a.length;
		long maxValue = a[0];
		long[] leftDp = new long[n];
		long[] rightDp = new long[n];
		int i,j;
		leftDp[0] = 0;
		rightDp[n-1] = 0;
		for(i=1,j=n-2;i<n && j>=0;i++,j--)
		{
			maxValue = Math.max(maxValue, a[i]);
			leftDp[i] = leftDp[i-1] + a[i-1];
			if(leftDp[i] < 0) leftDp[i] = 0;
			rightDp[j] = rightDp[j+1] + a[j+1];
			if(rightDp[j] < 0) rightDp[j] = 0;
		}
		if(maxValue < 0) return maxValue;
		long maxm = Math.max(leftDp[0] + rightDp[0] , leftDp[0] + rightDp[0] + a[0]);
		for(i=1;i<n;i++)
		{
			long maxm1 = (long) Math.max(leftDp[i] + rightDp[i] , leftDp[i] + rightDp[i] + a[i]);
		    maxm = Math.max(maxm, maxm1);	
		}
			
		return maxm;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			    s = br.readLine();
			    if(s!=null)
			    {
			    	int t = Integer.parseInt(s);
			    	while(t>0)
			    	{
			    		s = br.readLine();
			    		//long n = Long.parseLong(s);
			    		int n = Integer.parseInt(s);
			    	    long[] a = new long[n];
			    		s = br.readLine();//ai
			    		String[] s1 = s.split(" ");
			    		int i;
			    		for(i=0;i<n;i++)
			    		{
			    			a[i] = Long.parseLong(s1[i]);
			    		}
			    		long ans  = maximumSum(a);
			    		System.out.println(ans);
			    		t--;
			    	}
			    }		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
