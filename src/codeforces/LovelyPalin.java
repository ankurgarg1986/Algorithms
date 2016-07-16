package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class LovelyPalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		 try {
			s = br.readLine();
			//BigInteger n  = new BigInteger(s);
			StringBuilder sb  = new StringBuilder();
			sb.append(s);
			for(int i=s.length()-1;i>=0;i--)
			{
			   	sb.append(s.charAt(i));
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
