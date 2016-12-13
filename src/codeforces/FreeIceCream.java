package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FreeIceCream {

	
	
	public static void main(String[] args) {
	try{
	  int c  = 4/0;
	  
	}catch(Exception e){
	  System.out.println("Exception");
	}finally{
	  System.out.println("Finally");
	}
	  
	  
	  // TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		//long x = 0;
		long cnt  = 0;
		try {
			    s = br.readLine();
			    if(s!=null)
			    {
			    	String[] s1 = s.split(" ");
			    	long n = Long.parseLong(s1[0]);
			    	long x =  Long.parseLong(s1[1]);
			    	for(int i=0;i<n;i++)
			    	{
			    		 s = br.readLine();
			    		 s1 = s.split(" ");
			    		 long t =  Long.parseLong(s1[1]);
			    		 if(s1[0].equals("-"))
			    		 {
			    			 if(x>=t)
			    			 {
			    				 x = x-t;
			    			 }
			    			 else 
			    				 cnt++;
			    		 }
			    		 else
			    		 {
			    			 x = x +t;
			    		 }
			    		
			    	}
			    	System.out.println(x + " " + cnt);
			    }		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
