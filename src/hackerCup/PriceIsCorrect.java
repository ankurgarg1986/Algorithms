package hackerCup;

import java.util.Scanner;

/**
 * 
 * @author agarg Solution for Facebook HackerCup 2016 Problem can be found here
 *         (https://www.facebook.com/hackercup/problem/881509321917182)
 */
public class PriceIsCorrect {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] b = null;
		int i,j;
		for ( i = 0; i < T; i++) {
			int N = s.nextInt();// in[1];
			b = new int[N];
			int P = s.nextInt();// in[2];
			for(j=0;j<N;j++)
			{	
				b[j] = s.nextInt();
			}
			int c = i+1;
			System.out.println("Case #" + c + ": " + findAns(b,P));
		}
		

	}

	// 1 2 3 4 1 3  =>7  1+2+3+4
	private static int findAns(int[] b, int p) {
		
		int n = b.length;
		int ans = 0;
		int i=0,j=0;
		int sum = b[i];
		j=1;
		boolean[] vis = new boolean[n];
		for(i=0;i>n;i++)
			 vis[i] = false;
		int sIndex = 0;
		while(j<n)
		{
		    if(sum > p)
		    {
		    	while(sIndex < j )
		    	{
		    		sum = sum - b[sIndex];
		    	}
		    }
		    
			
		}
		//ans += compute(sIndex,j,vis);
		return ans;
		
	}

	private static int compute(int sIndex, int j,boolean[] vis) {
		int n = vis.length;
		int val = (j-sIndex)*(j-sIndex+1)/2;
		for(int i=sIndex ;i <= j;i++)
		{
			if(vis[i])
				val--;
			else
				vis[i] = true;
		}
		return val;
	}

}
