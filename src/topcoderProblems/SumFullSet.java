package topcoderProblems;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SumFullSet
{
	public static String isSumFullSet(int[] e)
	{
	    if(e.length == 1) return "closed";
		Arrays.sort(e);
		int n  = e.length;
		int i,j;
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;i++)
			{
				int sum = e[i] + e[j];
				if(!exists(e,sum))
				{
					return "not closed";
				}
			}
		}
	   return "closed";  
	}

	private static boolean exists(int[] e, int sum) {
		// TODO Auto-generated method stub
		for(int i=0;i<e.length;i++)
		{
			if(sum==e[i])
				 return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] e = {-1,0,1};
        System.out.println(isSumFullSet(e));
	}

}
