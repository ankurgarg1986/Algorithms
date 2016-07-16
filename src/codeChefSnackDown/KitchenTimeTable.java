package codeChefSnackDown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author agarg
 *
 */
public class KitchenTimeTable {
	
	private static int  findNumberOfStudents(int[] a, int[] b, int n) {
		//1 10 15 => 1 9 5
		int i = 0;
		int ans= 0;
		for(i=0;i<n;i++)
		{
			if(b[i] <= a[i] )
				ans++;
		}
		return ans;
	}



	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer token;
		String s;
		try {
			    s = br.readLine();
			    if(s!=null)
			    {
			    	int t = Integer.parseInt(s);
			    	while(t>0)
			    	{
			    		s = br.readLine();
			    		int n = Integer.parseInt(s);
			    		int[] a = new int[n];
			    		int[] b = new int[n];
			    		s = br.readLine();//ai
			    		String[] s1 = s.split(" ");
			    		int i;
			    		int x = 0;
			    		int[] t1 = new int[n];
			    		for(i=0;i<n;i++)
			    		{
			    			a[i] = Integer.parseInt(s1[i]);
			    			t1[i] = a[i] -x;
			    			x = a[i];
			    		}
			    		s = br.readLine();
			    		String[] s2 = s.split(" ");
			    		for(i=0;i<n;i++)
			    		{
			    			b[i] = Integer.parseInt(s2[i]); 
			    		}
			    		int ans  = findNumberOfStudents(t1,b,n);
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
