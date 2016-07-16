package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Opponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			s = br.readLine();
			if(s!=null)
		    {
		    	String[] s1 = s.split(" ");
		    	int n = Integer.parseInt(s1[0]);
		    	int d = Integer.parseInt(s1[1]);
		    	int i= 0 ;
		    	int ans = 0;
		    	int maxAns = 0;
		    	int bit = 1;
		    	while(d>0)
		    	{
		    		bit = 1;
		    		s = br.readLine();
		    		for(i=0;i<s.length();i++)
		    		{
		    			bit = bit & (s.charAt(i)- '0');
		    			if(bit == 0)
		    			{
		    				ans ++; //won today go for next
		    				break;
		    			}
		    		}
		    		if(bit == 0)
		    		{
		    			maxAns = Math.max(ans, maxAns);
		    		}
		    		if(bit == 1)
		    		{
		    			//lost today , so reset
		    			ans  = 0;
		    		}
		    		d--;
		    	}
		    	System.out.println(maxAns);
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
