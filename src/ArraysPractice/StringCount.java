package ArraysPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringCount {

	public static void main(String[] args) throws Exception {
		List<String> res = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int i;
		boolean flag = false;
		String s1 ="";
		for(i=0;i<s.length();i++)
		{
			while(i<s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <=9)
			{
				s1 += s.charAt(i);
				i++;
			}
			if(!s1.equals(""))
			{
			  res.add(s1);
			  s1 = "";
			}
		}
		for(i=0;i<res.size();i++)
			System.out.println(res.get(i));
		

	}

}
