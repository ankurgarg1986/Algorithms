package ArraysPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSorted {

	public static void main(String[] args) throws IOException {
		/*
		 * Read input from stdin and provide input before running
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		long n = Long.parseLong(s);
		int i, j;
		s = br.readLine();
		String[] s1 = s.split(" ");
		long[] a = new long[(int) n];
		for (j = 0; j < n; j++) {
			a[j] = Long.parseLong(s1[j]);
		}
		// }
		s = br.readLine();
		long m  = Long.parseLong(s);
		s = br.readLine();
		 s1 = s.split(" ");
		long[] b = new long[(int) m];
		for (i = 0; i < m; i++) {
			b[i] = Long.parseLong(s1[i]);
		}
		long[] res = new long[(int) (m+n)]; //result array
	    long minm,maxm;
	    if(a[0] > b[0])
	    {
	    	minm = b[0];
	    	maxm = a[0];
	    	res[0] = b[0];
	    	i = 0;
	    	j = 1;
	    }
	    else
	    {
	    	minm = a[0];
	    	maxm = b[0];
	    	res[0] = a[0];
	    	i = 1;
	    	j = 0;
	    }
	    int k;
		for(k=1;k<m+n;k++)
	    {
			if(i==n)
			{
				while(j!=m)
				{
					res[k] = b[j];
					k++;
					j++;
				}
				break;
			}
			
			if(j==m)
			{
				while(i!=n)
				{
					res[k] = a[i];
					k++;
					i++;
				}
				break;
			}
	    	if(a[i] <= b[j])
	    	{
	    	   res[k] = a[i];
	    	   i++;
	    	   continue;
	    	}
	    	else if(a[i] > b[j])
	    	{
	    		res[k] = b[j];
	    		j++;
	    		continue;
	    	}
	    		
	    }
		for(k=0;k<m+n;k++)
			System.out.print(res[k] + " ");

	}

}
