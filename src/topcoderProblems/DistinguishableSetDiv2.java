package topcoderProblems;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

/**
 * Solution for SRM 694 Div2 500 point
 * @author agarg
 *
 */
public class DistinguishableSetDiv2
{
	
	public int count(String[] a)
	{
		int n  = a.length;
		int m = a[0].length();
		int t = 1<<m; //no of Power Sets
		int ans = 0;
		int i,j;
		for(i=1;i<t;i++)
		{
			List<Integer> l = new ArrayList<Integer>();
			for(j=0;j<m;j++)
			{
				if((i & 1<<j) > 0)
				{
					l.add(j);
				}
			}
			ans += findCount(a,l,n);
		}
		return ans;
	}

	private int findCount(String[] a, List<Integer> l,int n) {
		int i,j;
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				String a1 = a[i];
				String a2 = a[j];
				String x = "";
				String y = "";
				for(int k=0;k<l.size();k++)
				{
					 x += a1.charAt(l.get(k));
					 y += a2.charAt(l.get(k));
				}
				if(x.equalsIgnoreCase(y))
					return 0;
			}
		}
		return 1;
	}
	
	
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		time = System.currentTimeMillis();
//		answer = new DistinguishableSetDiv2().count(new String[]{"AA","AB","CC"});
//		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
//		desiredAnswer = 2;
//		System.out.println("Your answer:");
//		System.out.println("\t" + answer);
//		System.out.println("Desired answer:");
//		System.out.println("\t" + desiredAnswer);
//		if (answer != desiredAnswer)
//		{
//			errors = true;
//			System.out.println("DOESN'T MATCH!!!!");
//		}
//		else
//			System.out.println("Match :-)");
//		System.out.println();
//		time = System.currentTimeMillis();
//		answer = new DistinguishableSetDiv2().count(new String[]{"XYZ","XYZ","XYZ"});
//		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
//		desiredAnswer = 0;
//		System.out.println("Your answer:");
//		System.out.println("\t" + answer);
//		System.out.println("Desired answer:");
//		System.out.println("\t" + desiredAnswer);
//		if (answer != desiredAnswer)
//		{
//			errors = true;
//			System.out.println("DOESN'T MATCH!!!!");
//		}
//		else
//			System.out.println("Match :-)");
//		System.out.println();
		time = System.currentTimeMillis();
		answer = new DistinguishableSetDiv2().count(new String[]{"AAAA","BACA","CDCE"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 11;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new DistinguishableSetDiv2().count(new String[]{"HGHHGUHUHI","BQHJWOSZMM","NDKSKCNXND","QOEOEIWIDS","IIQIWUNNZM"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1017;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new DistinguishableSetDiv2().count(new String[]{"XYZ","XAB","YAC"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

	
	
}
//Powered by [KawigiEdit] 2.0!