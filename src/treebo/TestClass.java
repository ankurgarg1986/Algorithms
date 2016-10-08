package treebo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for (int i = 0; i < t; i++) {
        	 line = br.readLine();
        	 int len = line.length();
        	 if(len==1){
        		 int num = Integer.parseInt(line);
        		 if(num == 4 || num==8) System.out.println("Yes");
        		 else System.out.println("No");
        	 }
        	 String s =  line.substring(len-2);
        	 int n = Integer.parseInt(s);
        	 FindAnswer(n);
        	 
        }
        

       
    }

	private static void FindAnswer(int n) {
		if(n%4==0){
   		 System.out.println("Yes");
   	 }
   	 else{
   		 System.out.println("No");
   	 }
   	 
		
	}
}